package com.ushieru.une.watson.lab.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Hardware extends PanacheEntity {
    public String name;
    public int quantity;
}
