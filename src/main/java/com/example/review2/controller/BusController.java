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

import com.example.review2.model.Bus;
import com.example.review2.service.BusService;


@RestController
public class BusController {
    @Autowired
    BusService os;
    @PostMapping("/post/buses")
    public ResponseEntity<Bus>addelements(@RequestBody Bus k)
    {
        Bus ovt=os.create(k);
        return new ResponseEntity<>(ovt,HttpStatus.CREATED);
    }
    @GetMapping("/get/buses")
    public ResponseEntity<List<Bus>> showinfo()
    {
        return new ResponseEntity<>(os.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get/buses/{bid}")
    public ResponseEntity<Bus> getById(@PathVariable Integer bid)
    {
        Bus objjo=os.getId(bid);
        return new ResponseEntity<>(objjo,HttpStatus.OK);
    }
    @PutMapping("/put/buses/{bid}")
    public ResponseEntity<Bus> putMethodName(@PathVariable("bid") int bid, @RequestBody Bus o) {
        if(os.update(bid,o) == true)
        {
            return new ResponseEntity<>(o,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        
    }
    @DeleteMapping("/delete/buses/{bid}")
    public ResponseEntity<Boolean> delete(@PathVariable("bid") int bid)
    {
        if(os.delete(bid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
     @GetMapping("bus/busid")
     public List<Bus> getBusWithBusIdd() {
         return os.getBusWithBusId();
     }
   
}