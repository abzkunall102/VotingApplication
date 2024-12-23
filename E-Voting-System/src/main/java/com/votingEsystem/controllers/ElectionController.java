package com.votingEsystem.controllers;

import com.votingEsystem.Entities.Election;
import com.votingEsystem.Services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElectionController {

    @Autowired
    ElectionService electionService;

    @GetMapping("/test")
    String test(){
        return "Hi";
    }




    @PostMapping("/add/election")
    public void createElection(@RequestBody Election election){
       electionService.createElection(election);


    }

    @GetMapping("/get/elections")
    List<Election> getElections(){
       return electionService.getAllElections();

    }
}
