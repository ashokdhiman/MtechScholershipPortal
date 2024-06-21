package com.MtechScholershipPortal.ScholershipPortal.service;

import com.MtechScholershipPortal.ScholershipPortal.entity.Scholership;
import com.MtechScholershipPortal.ScholershipPortal.repository.ScholershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ScholershipService {
    @Autowired
    private ScholershipRepo scholershipRepo;

    public void saveScholership(Scholership scholership){
        scholershipRepo.save(scholership);
    }

    public List<Scholership> getAll(){
        return scholershipRepo.findAll();
    }

    public Optional<Scholership> findById(Long id){
        return scholershipRepo.findById(id);
    }

    public void deleteById(Long id){
        scholershipRepo.deleteById(id);
    }

    public Scholership findByRollNo(long rollNo){
        return scholershipRepo.findByRollNo(rollNo);
    }
}
