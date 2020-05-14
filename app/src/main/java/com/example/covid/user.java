package com.example.covid;

import java.util.GregorianCalendar;

public class user {
    private String name,phNo,state,city,locality;
    private int volunteer,rawMaterial,transportation;
    private GregorianCalendar dob;

    public user(String name,String phNo,GregorianCalendar dob,String state,String city,String locality,int volunteer,int rawMaterial,int transportation)
    {
        this.name=name;
        this.phNo=phNo;
        this.dob=dob;
        this.state=state;
        this.city=city;
        this.locality=locality;
        this.volunteer=volunteer;
        this.rawMaterial=rawMaterial;
        this.transportation=transportation;
    }

    public GregorianCalendar getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int isVolunteer() {
        return volunteer;
    }

    public void setVolunteer(int volunteer) {
        this.volunteer = volunteer;
    }

    public int isRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(int rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public int isTransportation() {
        return transportation;
    }

    public void setTransportation(int transportation) {
        this.transportation = transportation;
    }
}
