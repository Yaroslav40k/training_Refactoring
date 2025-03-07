package com.andersen.training.training_refactoring;

import java.time.LocalDate;
import java.util.List;

class F1RaceResultsDto {
    public LocalDate date;
    public String country;
    public String track;
    public List<DriverResultDto> results;
}
