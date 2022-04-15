package com.paradz3033.controller;

import com.paradz3033.model.Movie;
import com.paradz3033.model.Screening;
import com.paradz3033.service.MovieService;
import com.paradz3033.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    ScreeningService screeningService;

    @RequestMapping(value = "/movies", method= RequestMethod.GET)
    public ModelAndView showMovies(){
        ModelAndView mav = new ModelAndView("movie_list");
        mav.addObject("movies",movieService.getMovies());
        mav.addObject("screenings",screeningService.getScreenings());
        mav.addObject("movie",new Movie());
        return mav;
    }

    @RequestMapping(value = "/movies", method= RequestMethod.POST)
    public String submitMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("movies",movieService.getMovies());
            model.addAttribute("screenings",screeningService.getScreenings());
            return "movie_list";
        }
        movieService.addMovie(movie);
        model.addAttribute("movie",movie);
        return "movie_added";
    }

    @RequestMapping(value = "/movies/{id}", method= RequestMethod.GET)
    public String showMovie(@PathVariable int id,Model model){
        Movie movie = movieService.getMovie(id);
        if(movie != null) {
            model.addAttribute("mov", movie);
            model.addAttribute("screenings",screeningService.getScreenings(id));
            return "movie";
        }else{
            model.addAttribute("error_message", "Error404: Movie not found");
            return "error";
        }
    }

    @RequestMapping(value="**",method = RequestMethod.GET)
    public String pageNotFound(Model model){
        model.addAttribute("error_message","Error404: Page not found!");
        return "error";
    }
}
