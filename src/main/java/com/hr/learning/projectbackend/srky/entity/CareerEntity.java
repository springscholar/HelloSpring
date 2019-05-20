package com.hr.learning.projectbackend.srky.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CAREER")
public class CareerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CareerEntityKey compositePrimaryKey ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_DATE")
    private Date creation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_DATE")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name="PLAYER_ID", referencedColumnName="ID", insertable=false, updatable=false)
    private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name="CLUB_ID", referencedColumnName="ID", insertable=false, updatable=false)
    private ClubEntity club;

    public CareerEntity(){
        super();
        this.compositePrimaryKey = new CareerEntityKey();
    }

    public CareerEntityKey getCompositePrimaryKey() {
        return compositePrimaryKey;
    }

    public void setCompositePrimaryKey(CareerEntityKey compositePrimaryKey) {
        this.compositePrimaryKey = compositePrimaryKey;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public ClubEntity getClub() {
        return club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "CareerEntity{" +
                "compositePrimaryKey=" + compositePrimaryKey +
                ", creation=" + creation +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
