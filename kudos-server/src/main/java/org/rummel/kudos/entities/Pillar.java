package org.rummel.kudos.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Pillar {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    private String tenet;
    private String line;

    public Pillar() {}

    public Pillar(String tenet, String line) {
        this.tenet = tenet;
        this.line = line;
    }

}

