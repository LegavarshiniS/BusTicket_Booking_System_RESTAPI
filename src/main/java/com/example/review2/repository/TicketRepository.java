package com.example.review2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.review2.model.Ticket;


public interface TicketRepository extends JpaRepository<Ticket,Integer> 
{
    @Query("SELECT t FROM Ticket t WHERE t.seatno = 5")
    List<Ticket> findBySeat();
}