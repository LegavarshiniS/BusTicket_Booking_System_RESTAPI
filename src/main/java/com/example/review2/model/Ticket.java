package com.example.review2.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket {
   
    @Id
    private int tid;
    
     public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

     private String source;
     private String destination;
     private int seatno;
     private int price;
     private String dateofjourney;
    public Ticket() {
    }

    public Ticket(int tid, String source, String destination, int seatno, int price, String dateofjourney) {
        this.tid = tid;
        this.source = source;
        this.destination = destination;
        this.seatno = seatno;
        this.price = price;
        this.dateofjourney = dateofjourney;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSeatno() {
        return seatno;
    }

    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateofjourney() {
        return dateofjourney;
    }

    public void setDateofjourney(String dateofjourney) {
        this.dateofjourney = dateofjourney;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bus_bid")
    @JsonBackReference
    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }


    
}