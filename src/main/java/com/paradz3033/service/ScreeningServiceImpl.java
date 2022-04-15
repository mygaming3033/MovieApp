package com.paradz3033.service;

import com.paradz3033.dao.MovieDao;
import com.paradz3033.dao.ScreeningDao;
import com.paradz3033.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScreeningServiceImpl implements ScreeningService{
    @Autowired
    ScreeningDao screeningDao;

    @Override
    public List<Screening> getScreenings() {
        return screeningDao.getScreenings();
    }

    @Override
    public List<Screening> getScreenings(long movieId) {
        return screeningDao.getScreenings(movieId);
    }

    @Override
    public boolean addScreening(Screening screening) {
        return screeningDao.addScreening(screening);
    }

    @Override
    public boolean isHallAvaliable(Screening screening) {
        for(Screening screen : screeningDao.getScreenings()){
            if(screen.getHall().equalsIgnoreCase(screening.getHall())){
                if(screening.getStartTime().plusMinutes(1).isAfter(screen.getStartTime()) && screening.getStartTime().minusMinutes(1).isBefore(screen.getEndTime())){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean deleteScreening(long id) {
        return screeningDao.deleteScreening(id);
    }
}
