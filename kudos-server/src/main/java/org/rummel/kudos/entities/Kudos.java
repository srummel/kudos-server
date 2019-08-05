package org.rummel.kudos.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Kudos {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @OneToOne
    private Employee author;

    @OneToOne
    private Employee recipient;

    @OneToOne
    private Pillar pillar;

    private String message;

    public Kudos() {}

    public Kudos(Employee author) {
        this.author = author;
    }

}

