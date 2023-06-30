package com.mongoExample.mongoDemo.repository;

import com.mongoExample.mongoDemo.controller.rs.Humineral;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumineralRepository extends MongoRepository<Humineral, String> {

    List<Humineral> findByName(String name);

    List<Humineral> findByFather(String authorName);

    List<Humineral> findByMother(String authorName);

    List<Humineral> findByNationality(String nationality);

    List<Humineral> findBySocialCreditScore(int score);
}
