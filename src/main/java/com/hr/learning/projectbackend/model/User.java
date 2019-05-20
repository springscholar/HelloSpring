package com.hr.learning.projectbackend.model;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue()
    private Long id;

    @Column(name="name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
