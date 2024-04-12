package com.example.review2.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.review2.model.Bus;

public interface BusRepository extends JpaRepository<Bus,Integer>
{
    @Query("SELECT b FROM Bus b WHERE b.bid = 1")
    List<Bus> findByBusId();
}
