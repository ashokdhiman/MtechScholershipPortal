package com.MtechScholershipPortal.ScholershipPortal.service;

import com.MtechScholershipPortal.ScholershipPortal.entity.Load;
import com.MtechScholershipPortal.ScholershipPortal.entity.Scholership;
import com.MtechScholershipPortal.ScholershipPortal.repository.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class LoadService {
    @Autowired
    LoadRepo loadRepo;

    @Autowired
    private ScholershipService scholershipService;

    @Transactional
    public void saveLoad(Load load, Long rollNo){
        try {
            Scholership scholership = scholershipService.findByRollNo(rollNo);
            Load saved = loadRepo.save(load);
            scholership.getLoad().add(saved);
            scholershipService.saveScholership(scholership);
        } catch (Exception e){
            throw new RuntimeException("An error occurred while saving the entry.",e);
        }
    }

    public void saveLoad(Load load){
        loadRepo.save(load);
    }

    public List<Load> getAll(){
        return loadRepo.findAll();
    }

    public Optional<Load> findById(Long id){
        return loadRepo.findById(id);
    }

    public void deleteById(Long id, Long rollNo){
        Scholership scholership = scholershipService.findByRollNo(rollNo);
        scholership.getLoad().removeIf(x->x.getWeekNo()==id);
        scholershipService.saveScholership(scholership);
        loadRepo.deleteById(id);
    }
}
