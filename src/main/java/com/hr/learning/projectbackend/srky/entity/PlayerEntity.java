package com.hr.learning.projectbackend.srky.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="PLAYER")
public class PlayerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue()
    private Integer id;

    @Column(name="FIRST_NAME", length=40)
    private String firstName;

    @Column(name="LAST_NAME", length=40)
    private String lastName;

    @OneToMany(mappedBy="player", targetEntity=CareerEntity.class)
    private List<CareerEntity> listOfCareer;

    public PlayerEntity() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CareerEntity> getListOfCareer() {
        return listOfCareer;
    }

    public void setListOfCareer(List<CareerEntity> listOfCareer) {
        this.listOfCareer = listOfCareer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
