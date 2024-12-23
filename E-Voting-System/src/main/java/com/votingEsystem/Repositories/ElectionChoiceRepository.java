package com.votingEsystem.Repositories;

import com.votingEsystem.Entities.Election;
import com.votingEsystem.Entities.ElectionChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice, Long> {


    @Query("select count(Ec) from ElectionChoice Ec where Ec.election=:election")
    int getElectionChoiceByElection(@Param("election") Election election);

    Optional<ElectionChoice> findByNameAndElection(String electionChoicName, Election election);


    @Query(value ="SELECT ec.* FROM election_choice ec "
            + "JOIN vote v ON ec.id = v.election_choice_id "
            + "WHERE ec.election_id = :electionId "
            + "GROUP BY ec.id "
            + "ORDER BY COUNT(v.id) DESC LIMIT 1", nativeQuery = true)
    ElectionChoice getElectionWinner(@Param("electionId") Long electionId);
}
