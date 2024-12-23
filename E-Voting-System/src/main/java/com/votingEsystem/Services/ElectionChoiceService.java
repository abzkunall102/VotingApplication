package com.votingEsystem.Services;

import com.votingEsystem.Entities.Election;
import com.votingEsystem.Entities.ElectionChoice;
import com.votingEsystem.Repositories.ElectionChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionChoiceService {


    @Autowired
    ElectionChoiceRepository electionChoiceRepository;

    public List<ElectionChoice> getAllElectionChoices() {
       return  electionChoiceRepository.findAll();
    }

    public void addElectionChoice(ElectionChoice electionChoice) {
        electionChoiceRepository.save(electionChoice);
    }

    public int getElectionChoicesByElection(Election election) {

        return electionChoiceRepository.getElectionChoiceByElection(election);


    }
    public ElectionChoice findElectionChoiceByNameAndElection(String ElectionChoicName, Election election){
        return electionChoiceRepository.findByNameAndElection(ElectionChoicName, election).orElseThrow();

    }

    public ElectionChoice getElectionWinner(Election updatedElection) {
        return electionChoiceRepository.getElectionWinner(updatedElection.getId());

    }
}
