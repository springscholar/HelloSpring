package com.hr.learning.projectbackend.srky.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CLUB")
public class ClubEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue()
    private Integer id;

    @Column(name="NAME", length=40)
    private String name;

    @OneToMany(mappedBy="club", targetEntity=CareerEntity.class)
    private List<CareerEntity> listOfCareer;

    public ClubEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CareerEntity> getListOfCareer() {
        return listOfCareer;
    }

    public void setListOfCareer(List<CareerEntity> listOfCareer) {
        this.listOfCareer = listOfCareer;
    }

    @Override
    public String toString() {
        return "ClubEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
