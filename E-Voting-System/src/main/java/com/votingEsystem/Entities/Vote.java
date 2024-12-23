package com.votingEsystem.Entities;

import jakarta.persistence.*;

@Entity
public class Vote {


    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    long id;

    @OneToOne(cascade=CascadeType.ALL)
    User user;

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public ElectionChoice getElectionChoice() {
        return electionChoice;
    }

    public void setElectionChoice(ElectionChoice electionChoice) {
        this.electionChoice = electionChoice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade =CascadeType.ALL)
    Election election;

    @ManyToOne(cascade =CascadeType.ALL)
    ElectionChoice electionChoice;


}
