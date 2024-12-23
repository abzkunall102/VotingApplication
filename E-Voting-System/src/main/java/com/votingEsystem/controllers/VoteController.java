package com.votingEsystem.controllers;

import com.votingEsystem.Entities.Election;
import com.votingEsystem.Entities.ElectionChoice;
import com.votingEsystem.Entities.User;
import com.votingEsystem.Entities.Vote;
import com.votingEsystem.Services.ElectionChoiceService;
import com.votingEsystem.Services.ElectionService;
import com.votingEsystem.Services.UserService;
import com.votingEsystem.Services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoteController {

    @Autowired
    ElectionService electionService;

    @Autowired
    ElectionChoiceService electionChoiceService;

    @Autowired
    UserService userService;

    @Autowired
    VoteService voteService;
    @GetMapping("/get/votes")
    List<Vote> getAllVotes(){
        return voteService.getAllVotes();


    }

    @PostMapping("/add/votes")
    void addVotes(@RequestBody Vote vote){
        Vote newVote= new Vote();
        Election election=electionService.findByName(vote.getElection().getName());
        User user= userService.findByName(vote.getUser().getName());
        ElectionChoice electionChoice= electionChoiceService.findElectionChoiceByNameAndElection(vote.getElectionChoice().getName(),election);
        newVote.setElection(election);
        newVote.setUser(user);
        newVote.setUser(user);
        newVote.setElectionChoice(electionChoice);

        voteService.addVote(newVote);

    }

    @GetMapping("/count/votes")
    long countVotes(){
        return voteService.countVotes();

    }

    @PostMapping("/count/election/votes")
    long countElectionVotes(@RequestBody Election election){
        Election updatedElection= electionService.findByName(election.getName());
        return voteService.getCountElectionVotes(updatedElection);
    }

}
