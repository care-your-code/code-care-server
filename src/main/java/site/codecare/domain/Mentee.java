package site.codecare.domain;

import javax.persistence.*;

@Entity
public class Mentee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    private String name;
}
