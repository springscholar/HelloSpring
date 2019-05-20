package com.hr.learning.projectbackend.srky.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CareerEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="PLAYER_ID", nullable=false)
    private Integer playerId;

    @Column(name="CLUB_ID", nullable=false)
    private Integer clubId;

    public CareerEntityKey(){

    }

    public CareerEntityKey(Integer playerId, Integer clubId) {
        this.playerId = playerId;
        this.clubId = clubId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerEntityKey that = (CareerEntityKey) o;
        return playerId.equals(that.playerId) &&
                clubId.equals(that.clubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, clubId);
    }

    @Override
    public String toString() {
        return "CareerEntityKey{" +
                "playerId=" + playerId +
                ", clubId=" + clubId +
                '}';
    }
}
