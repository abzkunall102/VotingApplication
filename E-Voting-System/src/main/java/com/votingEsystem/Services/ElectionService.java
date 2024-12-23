package com.votingEsystem.Services;

import com.votingEsystem.Entities.Election;
import com.votingEsystem.Repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionService {
    @Autowired
    ElectionRepository electionRepository;


    public void createElection(Election election) {
        electionRepository.save(election);
    }

    public List<Election> getAllElections() {
return electionRepository.findAll();
    }

    public Election findByName(String name) {
       return electionRepository.findByName(name).orElseThrow();
    }
}
