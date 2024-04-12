package com.example.review2.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
     @Id
     private int eid;
     public int getEid() {
      return eid;
    }
    public void setEid(int eid) {
      this.eid = eid;
    }
    private String fname;
    private String lname;
    private String email;

    public User(){

    }

    
    public User(int eid, String fname, String lname, String email) {
        this.eid = eid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }
    
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Bus> busdata=new ArrayList<>();
    public List<Bus> getBusdata() {
        return busdata;
    }
    public void setBusdata(List<Bus>  busdata) {
        this.busdata = busdata;
    }
}

