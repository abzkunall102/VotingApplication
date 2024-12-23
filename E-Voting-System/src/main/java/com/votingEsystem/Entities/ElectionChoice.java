package com.votingEsystem.Entities;

import jakarta.persistence.*;
@Table(name="ElectionChoice")
@Entity
public class ElectionChoice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    @Column
    String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    Election election;
//    public void setId(long id) {
//        this.id = id;
//    }






}
