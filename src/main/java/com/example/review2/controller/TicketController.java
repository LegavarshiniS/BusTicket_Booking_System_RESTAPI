package com.example.review2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.review2.model.Ticket;
import com.example.review2.service.TicketService;


@RestController
public class TicketController {
    @Autowired
    TicketService evt;
    @PostMapping("/post/ticket")
    public ResponseEntity<Ticket>addelements(@RequestBody Ticket n)
    {
        Ticket evty=evt.create(n);
        return new ResponseEntity<>(evty,HttpStatus.CREATED);
    }
    @GetMapping("/get/ticket")
    public ResponseEntity<List<Ticket>> showinfo()
    {
        return new ResponseEntity<>(evt.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get/ticket/{tid}")
    public ResponseEntity<Ticket> getById(@PathVariable Integer tid)
    {
        Ticket objj=evt.getId(tid);
        return new ResponseEntity<>(objj,HttpStatus.OK);
    }
    @PutMapping("/put/ticket/{tid}")
    public ResponseEntity<Ticket> putMethodName(@PathVariable("tid") int tid, @RequestBody Ticket ee) {
        if(evt.update(tid,ee) == true)
        {
            return new ResponseEntity<>(ee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        
    }
    @DeleteMapping("/delete/ticket/{tid}")
    public ResponseEntity<Boolean> delete(@PathVariable("tid") int tid)
    {
        if(evt.delete(tid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/seat-no")
    public List<Ticket> getUsersWithEidTwo() {
        return evt.getUsersWithSeatNo();
    }
   //sorting
   @GetMapping("/api/bookbus/sortBy/{field}")
   public List<Ticket> g(@PathVariable String field)
   {
       return evt.sort(field);
   }

   //pagination
   @GetMapping("/api/bookbus/{offset}/{pagesize}")
   public List<Ticket> get(@PathVariable int offset,@PathVariable int pagesize)
   {
       return evt.page(pagesize, offset);
   }
   
   //sorting and pagination
   @GetMapping("/api/bookbus/{offset}/{pagesize}/{field}")
   public List<Ticket> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
   {
       return evt.getsort(offset,pagesize,field);
   }
}