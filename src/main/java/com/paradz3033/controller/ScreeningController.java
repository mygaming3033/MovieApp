package com.paradz3033.controller;

import com.paradz3033.model.Movie;
import com.paradz3033.model.Screening;
import com.paradz3033.service.MovieService;
import com.paradz3033.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@Controller
@Validated
public class ScreeningController {

    @Autowired
    MovieService movieService;

    @Autowired
    ScreeningService screeningService;

    @RequestMapping(value = "/movies/{id}/screenings", method= RequestMethod.POST)
    public String submitScreening(@PathVariable int id, @RequestParam (name="hall") String hall, @RequestParam (name="startTime")  String startTime, Model model){
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(startTime);
        } catch (DateTimeParseException e) {
            model.addAttribute("error_message","Wrong DateTime input for startTime");
            return "error";
        }


        Screening screening = new Screening(id,hall,dateTime,dateTime.plusMinutes(30));
        if(!screeningService.isHallAvaliable(screening)){
            model.addAttribute("error_message","Error 400 - Bad request: Hall is not avaliable");
            return "error";
        }

        screeningService.addScreening(screening);
        model.addAttribute("movies",movieService.getMovies());
        model.addAttribute("screenings",screeningService.getScreenings());
        model.addAttribute("movie",new Movie());
        return "redirect:/movies";
    }


    @GetMapping("/screenings")
    public ModelAndView showScreenings(){
        ModelAndView mav = new ModelAndView("screenings");
        mav.addObject("movies",movieService.getMovies());
        mav.addObject("screenings",screeningService.getScreenings());
        return mav;
    }

    @RequestMapping(value = "/screenings/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id, Model model) {
        if(screeningService.deleteScreening(id)){
            return "redirect:/screenings";
        }
        model.addAttribute("error_message","Screening not found");
        return "error";
    }

}
