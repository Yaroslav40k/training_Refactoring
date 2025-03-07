package com.andersen.training.training_refactoring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "f1_races")
class F1RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String country;
    private String track;
    private String driver;
    private String car;
    private int position;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getTrack() { return track; }
    public void setTrack(String track) { this.track = track; }
    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }
    public String getCar() { return car; }
    public void setCar(String car) { this.car = car; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
}
