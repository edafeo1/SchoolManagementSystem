package com.fegoEdafe.SchoolSystem.model;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Qualifier("postgres")
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Roles(String name) {
        this.name = name;
    }

    public Roles() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
