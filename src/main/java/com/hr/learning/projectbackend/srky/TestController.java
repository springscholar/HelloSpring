package com.hr.learning.projectbackend.srky;

import com.hr.learning.projectbackend.model.User;
import com.hr.learning.projectbackend.srky.entity.CareerEntity;
import com.hr.learning.projectbackend.srky.entity.CareerEntityKey;
import com.hr.learning.projectbackend.srky.entity.ClubEntity;
import com.hr.learning.projectbackend.srky.entity.PlayerEntity;
import com.hr.learning.projectbackend.srky.repository.CareerRepository;
import com.hr.learning.projectbackend.srky.repository.ClubRepository;
import com.hr.learning.projectbackend.srky.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

@RestController
public class TestController {

    @Autowired
    CareerRepository careerRepo;

    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    ClubRepository clubRepo;


    @RequestMapping(value="/api/testAll",produces="application/json")
    public Object getUserName(){

        PlayerEntity pe = new PlayerEntity();
        pe.setFirstName("Goran");
        pe.setLastName("Kadnar");
        playerRepo.save(pe);

        ClubEntity ce = new ClubEntity();
        ce.setName("Ericsson Nikola Tesla");
        clubRepo.save(ce);

        CareerEntity careere = new CareerEntity();
        careere.setCompositePrimaryKey(new CareerEntityKey(pe.getId(),ce.getId()));
        careere.setCreation(new Date());
        careere.setLastUpdate(new Date());
        careerRepo.save(careere);

        return pe;
    }
}