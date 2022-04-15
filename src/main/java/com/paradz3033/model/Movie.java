package com.paradz3033.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "name")
    @NotEmpty(message = "This field can not be empty")
    String name;

    @Column(name = "directedBy")
    @NotEmpty(message = "This field can not be empty")
    String directedBy;

    @Min(value = 1000, message = "Wrong year!")
    @Max(value = 2025, message = "Wrong year!")
    @Column(name = "releaseYear")
    @NotNull(message = "This field can not be empty")
    int releaseYear;

    @Min(value = 0, message = "Wrong runningTime!")
    @Max(value = 220, message = "Wrong runningTime!")
    @Column(name = "runningTime")
    @NotNull(message = "This field can not be empty")
    int runningTime;

    @Column(name = "genres")
    @NotEmpty(message = "This field can not be empty")
    String[] genres;


    public Movie() {
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public String[] getGenres() {
        return genres;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

}
