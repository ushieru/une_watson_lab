package com.ushieru.une.watson.lab.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Book extends PanacheEntity {
    public String title;

    @ManyToOne
    public Author author;
}
