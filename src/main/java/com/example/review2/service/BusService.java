package com.example.review2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review2.model.Bus;
import com.example.review2.repository.BusRepository;

import java.util.List;
@Service
public class BusService {
     @Autowired
    BusRepository or;
     public Bus create(Bus eo){
      return or.save(eo);
     }
     public List<Bus> getAll(){
      return or.findAll();
     }
     public Bus getId(int bid){
      return or.findById(bid).orElse(null);
     }
     public List<Bus> getBusWithBusId() {
         return or.findByBusId();
     }
     public boolean update(int bid,Bus eeo){
          if(this.getId(bid)==null)
          {
              return false;
          }
          try{
              or.save(eeo);
          }
          catch(Exception ex)
          {
              return false;
          }
          return  true;
     }
     public boolean delete(int bid){
          if(this.getId(bid)==null){
             return false;
          }
          or.deleteById(bid);
          return true;
     }
}