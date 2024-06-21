package com.MtechScholershipPortal.ScholershipPortal.repository;

import com.MtechScholershipPortal.ScholershipPortal.entity.Load;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepo extends MongoRepository<Load,Long> {

}
