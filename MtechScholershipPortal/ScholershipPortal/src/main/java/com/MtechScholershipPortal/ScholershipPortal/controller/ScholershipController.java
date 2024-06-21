package com.MtechScholershipPortal.ScholershipPortal.controller;

import com.MtechScholershipPortal.ScholershipPortal.entity.Scholership;
import com.MtechScholershipPortal.ScholershipPortal.service.ScholershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scholership")
public class ScholershipController {

    @Autowired
    private ScholershipService scholershipService;


    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Scholership> all = scholershipService.getAll();
        if(all!=null && !all.isEmpty()) return new ResponseEntity<>(all,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Scholership> create(@RequestBody Scholership scholership){
        try {
            scholership.setDate(LocalDateTime.now());
            scholershipService.saveScholership(scholership);
            return new ResponseEntity<>(scholership,HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<Scholership> getById(@PathVariable Long myId){
        Optional<Scholership> scholership = scholershipService.findById(myId);
        if(scholership.isPresent()){
            return new ResponseEntity<>(scholership.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteById(@PathVariable Long myId){
        scholershipService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateById(@PathVariable Long myId,@RequestBody Scholership scholership){
        Scholership old=scholershipService.findById(myId).orElse(null);
        if(old!=null){
            old.setLeaves(scholership.getLeaves());
            old.setTotal_load(scholership.getTotal_load());
            old.setName(scholership.getName()!=null && !scholership.getName().equals("") ? scholership.getName() : old.getName());
            old.setMonth(scholership.getMonth()!=null && !scholership.getMonth().equals("") ? scholership.getMonth() : old.getMonth());
            old.setNameOfGuide(scholership.getNameOfGuide()!=null && !scholership.getNameOfGuide().equals("") ? scholership.getNameOfGuide() : old.getNameOfGuide());
            scholershipService.saveScholership(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
