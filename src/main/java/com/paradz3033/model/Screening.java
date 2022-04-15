package com.paradz3033.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "movieId")
    long movieId;

    @Column(name = "hall")
    String hall;

    @Column(name = "startTime")
    LocalDateTime startTime;

    @Column(name = "endTime")
    LocalDateTime endTime;


    public Screening() {
    }

    public Screening(long movieId, String hall,LocalDateTime startTime, LocalDateTime endTime) {
        this.movieId=movieId;
        this.hall=hall;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public long getId() {
        return id;
    }

    public long getMovieId() {
        return movieId;
    }

    public String getHall() {
        return hall;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
