package com.votingEsystem.Services;


import com.votingEsystem.Entities.Election;
import com.votingEsystem.Entities.Vote;
import com.votingEsystem.Repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    VoteRepository voteRepository;


    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public void addVote(Vote vote) {
        voteRepository.save(vote);
    }

    public long countVotes() {

        return voteRepository.countVotes();
    }

    public long getCountElectionVotes(Election election) {

   return voteRepository.countElectionVotes(election);
    }
}
