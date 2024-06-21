package com.MtechScholershipPortal.ScholershipPortal.controller;

import com.MtechScholershipPortal.ScholershipPortal.entity.Load;
import com.MtechScholershipPortal.ScholershipPortal.entity.Scholership;
import com.MtechScholershipPortal.ScholershipPortal.service.LoadService;
import com.MtechScholershipPortal.ScholershipPortal.service.ScholershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/load")
public class LoadController {
    @Autowired
    private LoadService loadService;

    @Autowired
    private ScholershipService scholershipService;

    @GetMapping("{rollNo}")
    public ResponseEntity<?> getAllLoadsOfScholership(@PathVariable Long rollNo){
        Scholership scholership = scholershipService.findByRollNo(rollNo);
        List<Load> all = scholership.getLoad();
        if(all!=null && !all.isEmpty()) return new ResponseEntity<>(all, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{rollNo}")
    public ResponseEntity<?> create(@PathVariable Long rollNo,@RequestBody Load load){
        try {
            loadService.saveLoad(load,rollNo);
            return new ResponseEntity<>(load,HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<?> getById(@PathVariable Long myId){
        Optional<Load> byId = loadService.findById(myId);
        if(byId.isPresent()) return new ResponseEntity<>(byId,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{rollNo}/{myId}")
    public ResponseEntity<?> deleteById(@PathVariable Long myId,@PathVariable Long rollNo){
        loadService.deleteById(myId,rollNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateById(@PathVariable Long myId,@RequestBody Load load){
        Load old=loadService.findById(myId).orElse(null);
        if(old!=null){
            old.setTeachingRelatedActivity(load.getTeachingRelatedActivity());
            old.setResearchRelatedActivity(load.getResearchRelatedActivity());
            old.setFacultyName(load.getFacultyName()!=null && !load.getFacultyName().equals("") ? load.getFacultyName() : old.getFacultyName());
            loadService.saveLoad(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
