package com.votingEsystem.Entities;

import jakarta.persistence.*;


@Table(name = "election")
@Entity
public class Election {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    String name;



    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
