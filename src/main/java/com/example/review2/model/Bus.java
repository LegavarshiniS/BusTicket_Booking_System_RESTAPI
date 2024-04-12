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

@Entity
public class Bus 
{
    @Id
    private int bid;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
    private String bustype;
    public Bus()
    {
        
    }
    public Bus(int bid, String bustype) {
        this.bid = bid;
        this.bustype = bustype;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_eid")
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ticket> ticketdata=new ArrayList<>();
    public List<Ticket> getTicketdata() {
        return ticketdata;
    }
    public void setTicketdata(List<Ticket> ticketdata) {
        this.ticketdata = ticketdata;
    }
    
}
