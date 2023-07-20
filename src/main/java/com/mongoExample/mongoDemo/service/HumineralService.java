package com.mongoExample.mongoDemo.service;

import com.mongoExample.mongoDemo.controller.rq.HumineralPostRq;
import com.mongoExample.mongoDemo.controller.rq.HumineralUpdateRq;
import com.mongoExample.mongoDemo.controller.rs.Humineral;

import java.util.List;

public interface HumineralService {

    Humineral createNewHumineral(HumineralPostRq postRq);

    Humineral updateHumineral(HumineralUpdateRq updateRq);

    Boolean deleteById(String id);

    Humineral getById(String humineralId);

    List<Humineral> getByName(String name);

    List<Humineral> getByFather(String father);

    List<Humineral> getByMother(String mother);

    List<Humineral> getByNationality(String nationality);

    List<Humineral> getBySocialCreditScore(int score);

    List<Humineral> getAll();

    List<Humineral> getBySocialCreditScoreAndNationality(int score, String nationality);
}
