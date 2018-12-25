package com.example.reservationsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="conference_room")
public class ConferenceRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name="identifier")
    private String identifier;

    @Column(name="level")
    @NotNull
    private Short level;

    @Column(name="available")
    @NotNull
    private Boolean available;

    @Column(name="standing_count")
    @NotNull
    private Integer standingCount;

    @Column(name="seats_count")
    @NotNull
    private Integer seatsCount;

    @Column(name="lying_count")
    private Integer lyingCount;

    @Column(name="hammock_count")
    private Integer hammockCount;

    @OneToOne(mappedBy = "conference_room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RoomEquipment roomEquipment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getStandingCount() {
        return standingCount;
    }

    public void setStandingCount(Integer standingCount) {
        this.standingCount = standingCount;
    }

    public Integer getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(Integer seatsCount) {
        this.seatsCount = seatsCount;
    }

    public Integer getLyingCount() {
        return lyingCount;
    }

    public void setLyingCount(Integer lyingCount) {
        this.lyingCount = lyingCount;
    }

    public Integer getHammockCount() {
        return hammockCount;
    }

    public void setHammockCount(Integer hammockCount) {
        this.hammockCount = hammockCount;
    }

    public RoomEquipment getRoomEquipment() {
        return roomEquipment;
    }

    public void setRoomEquipment(RoomEquipment roomEquipment) {
        if (roomEquipment == null) {
            if (this.roomEquipment != null) {
                this.roomEquipment.setConferenceRoom(null);
            }
        } else {
            roomEquipment.setConferenceRoom(this);
        }

        this.roomEquipment = roomEquipment;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}