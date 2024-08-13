package com.ushieru.une.watson.lab.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author extends PanacheEntity {
    public String name;

    @OneToMany(mappedBy = "author")
    List<Book> books = new ArrayList<>();
}
