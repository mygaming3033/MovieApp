package com.paradz3033.dao;

import com.paradz3033.model.Movie;
import com.paradz3033.model.Screening;

import java.util.List;

public interface ScreeningDao {
    List<Screening> getScreenings();
    List<Screening> getScreenings(long movieId);
    boolean addScreening(Screening screening);
    boolean deleteScreening(long id);
}
