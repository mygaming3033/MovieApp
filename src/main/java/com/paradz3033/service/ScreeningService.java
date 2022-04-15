package com.paradz3033.service;

import com.paradz3033.model.Movie;
import com.paradz3033.model.Screening;

import java.util.List;

public interface ScreeningService {
    List<Screening> getScreenings();
    List<Screening> getScreenings(long movieId);
    boolean addScreening(Screening screening);
    boolean isHallAvaliable(Screening screening);
    boolean deleteScreening(long id);
}
