package com.example.review2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review2.model.User;
import com.example.review2.repository.UserRepository;

import java.util.List;
@Service
public class UserService {
     @Autowired
     UserRepository ev;
     public User create(User e){
      return ev.save(e);
     }
     public List<User> getAll(){
      return ev.findAll();
     }
     public User getId(int eid){
      return ev.findById(eid).orElse(null);
     }
     public boolean update(int eid,User ee){
          if(this.getId(eid)==null)
          {
              return false;
          }
          try{
              ev.save(ee);
          }
          catch(Exception ex)
          {
              return false;
          }
          return  true;
     }
     public boolean delete(int eid){
          if(this.getId(eid)==null){
             return false;
          }
          ev.deleteById(eid);
          return true;
     }
}