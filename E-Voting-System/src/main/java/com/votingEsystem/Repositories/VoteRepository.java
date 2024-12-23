package com.votingEsystem.Repositories;

import com.votingEsystem.Entities.Election;
import com.votingEsystem.Entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {

    @Query("SELECT COUNT(*) FROM Vote ")
    long countVotes();

    @Query("Select Count(v) from Vote v where v.election=:election")
    long countElectionVotes(@Param("election") Election election);
}


