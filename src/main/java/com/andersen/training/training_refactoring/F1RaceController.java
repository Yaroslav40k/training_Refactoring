package com.andersen.training.training_refactoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/races")
class F1RaceController {

    @Autowired
    private F1RaceService raceService;

    @PostMapping("/save")
    public String saveRaceResults(@RequestBody List<F1RaceResultsDto> races) {
        for (F1RaceResultsDto race : races) {
            for (DriverResultDto driver: race.results) {
                F1RaceEntity entity = new F1RaceEntity();
                entity.setDate(race.date);
                entity.setCountry(race.country);
                entity.setTrack(race.track);
                entity.setDriver(driver.driver);
                entity.setCar(driver.car);
                entity.setPosition(driver.position);
                raceService.saveRace(entity);
            }
        }
        return "Saved";
    }

    @GetMapping("/chance/{driver}")
    public double getWinningChance(@PathVariable String driver) {
        List<F1RaceEntity> allRaces = raceService.getAllRaces();
        int total = 0;
        int wins = 0;
        for (F1RaceEntity race : allRaces) {
            if (race.getDriver().equalsIgnoreCase(driver)) {
                total++;
                if (race.getPosition() == 1) {
                    wins++;
                }
            }
        }
        return total == 0 ? 0 : (double) wins / total * 100;
    }
}

