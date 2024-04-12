package com.example.review2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.review2.model.Ticket;
import com.example.review2.repository.TicketRepository;

import java.util.List;
@Service
public class TicketService {
     @Autowired
     TicketRepository avt;
     public Ticket create(Ticket em){
      return avt.save(em);
     }
     public List<Ticket> getAll(){
      return avt.findAll();
     }
     public Ticket getId(int tid){
      return avt.findById(tid).orElse(null);
     }
     public List<Ticket> getUsersWithSeatNo() {
        return avt.findBySeat();
     }
     public boolean update(int tid,Ticket eee){
          if(this.getId(tid)==null)
          {
              return false;
          }
          try{
              avt.save(eee);
          }
          catch(Exception ex)
          {
              return false;
          }
          return  true;
     }
     public boolean delete(int tid){
          if(this.getId(tid)==null){
             return false;
          }
          avt.deleteById(tid);
          return true;
     }
     //sorting by field
    public List<Ticket> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return avt.findAll(sort);
    }

    //pagination
    public List<Ticket> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return avt.findAll(page).getContent();
    }

    //sorting and pagination
    public List<Ticket> getsort(int pageNumber,int pageSize,String field)
    {          return avt.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}