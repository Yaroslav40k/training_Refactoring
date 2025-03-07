package com.andersen.training.training_refactoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class F1RaceService {
    @Autowired
    private F1RaceRepository raceRepo;

    public void saveRace(F1RaceEntity race) {
        raceRepo.save(race);
    }

    public List<F1RaceEntity> getAllRaces() {
        return raceRepo.findAll();
    }
}
