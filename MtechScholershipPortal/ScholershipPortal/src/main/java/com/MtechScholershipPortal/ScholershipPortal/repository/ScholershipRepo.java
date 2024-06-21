package com.MtechScholershipPortal.ScholershipPortal.repository;

import com.MtechScholershipPortal.ScholershipPortal.entity.Scholership;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholershipRepo extends MongoRepository<Scholership,Long> {
    Scholership findByRollNo(long rollNo);
}
