package com.votingEsystem.controllers;

import com.votingEsystem.Entities.Election;
import com.votingEsystem.Entities.ElectionChoice;
import com.votingEsystem.Services.ElectionChoiceService;
import com.votingEsystem.Services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ElectionChoiceController {

@Autowired
    ElectionChoiceService electionChoiceService;

@Autowired
ElectionService electionService;

    @GetMapping("/get/electionChoices")
    List<ElectionChoice> getElectionChoices(){
        return electionChoiceService.getAllElectionChoices();
    }

    @PostMapping("/add/electionChoice")
    void addElectionChoice(@RequestBody ElectionChoice electionChoice){
        ElectionChoice updatedElectionChoice=new ElectionChoice();
        Election election= electionService.findByName(electionChoice.getElection().getName());
        updatedElectionChoice.setName(electionChoice.getName());
        updatedElectionChoice.setElection(election);
        electionChoiceService.addElectionChoice(updatedElectionChoice);


    }

    @PostMapping("/count/election/choices")
    int getElectionChoices(@RequestBody Election election){
        Election updatedElection= electionService.findByName(election.getName());


        return electionChoiceService.getElectionChoicesByElection(updatedElection);


    }


    @PostMapping("/winner/election")
    public ElectionChoice getElectionWinner(@RequestBody Election election){
        Election updatedElection=electionService.findByName(election.getName());

        return electionChoiceService.getElectionWinner(updatedElection);
    }

    //@GetMapping("get/election/")


//    ElectionChoice updatedElectionChoice = new ElectionChoice();
//    Election election = votingService.findElectionByName(electionChoice.getElection().getName());
//		updatedElectionChoice.setName(electionChoice.getName());
//		updatedElectionChoice.setElection(election);
//		votingService.addElectionChoice(updatedElectionChoice);


}
