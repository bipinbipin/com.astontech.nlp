package com.astontech.nlp.domain;

import javax.persistence.*;

/**
 * Created by anthmora1 on 6/27/2016.
 */

@Entity
public class Technology
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TechnologyId")
    private Integer id;

    @Version
    private Integer version;


}
