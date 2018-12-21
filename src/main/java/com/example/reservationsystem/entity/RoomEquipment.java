package com.example.reservationsystem.entity;

import javax.persistence.*;

@Table(name = "room_equipment")
public class RoomEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "projector_name")
    private String projectorName;

    @Column(name = "has_phone")
    private boolean hasPhone;

    @Column(name = "internal_number")
    private short internalNumber;

    @Column(name = "external_number")
    private String externalNumber;

    @Column(name = "connectionInterface")
    private String connectionInterface;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_room_id")
    private ConferenceRoom conferenceRoom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectorName() {
        return projectorName;
    }

    public void setProjectorName(String projectorName) {
        this.projectorName = projectorName;
    }

    public boolean isHasPhone() {
        return hasPhone;
    }

    public void setHasPhone(boolean hasPhone) {
        this.hasPhone = hasPhone;
    }

    public short getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(short internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
    }

    public String getConnectionInterface() {
        return connectionInterface;
    }

    public void setConnectionInterface(String connectionInterface) {
        this.connectionInterface = connectionInterface;
    }

    public ConferenceRoom getConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }
}