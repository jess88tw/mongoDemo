package com.mongoExample.mongoDemo.service.impl;

import com.mongoExample.mongoDemo.controller.rq.HumineralPostRq;
import com.mongoExample.mongoDemo.controller.rq.HumineralUpdateRq;
import com.mongoExample.mongoDemo.controller.rs.Humineral;
import com.mongoExample.mongoDemo.repository.HumineralRepository;
import com.mongoExample.mongoDemo.service.HumineralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HumineralServiceImpl implements HumineralService {

    private final HumineralRepository humineralRepository;

    @Override
    public Humineral createNewHumineral(HumineralPostRq postRq) {
        return humineralRepository.save(
                Humineral.builder()
                        .name(postRq.getName())
                        .description(postRq.getDescription())
                        .father(postRq.getFather())
                        .mother(postRq.getMother())
                        .nationality(postRq.getNationality())
                        .socialCreditScore(postRq.getSocialCreditScore())
                        .bornAt(new Date(System.currentTimeMillis()))
                        .lastUpdatedAt(new Date(System.currentTimeMillis()))
                        .build()
        );
    }

    @Override
    public Humineral updateHumineral(HumineralUpdateRq updateRq) {
        Optional<Humineral> existingHumineral = humineralRepository.findById(updateRq.getId());

        if (existingHumineral.isEmpty()) {
            log.error("Humineral with id {} not found", updateRq.getId());
            throw new RuntimeException(
                    String.format("No Humineral found for id: %s", updateRq.getId()));
        }

        existingHumineral.get().setName(updateRq.getName());
        existingHumineral.get().setDescription(updateRq.getDescription());
        existingHumineral.get().setFather(updateRq.getFather());
        existingHumineral.get().setMother(updateRq.getMother());
        existingHumineral.get().setNationality(updateRq.getNationality());
        existingHumineral.get().setSocialCreditScore(updateRq.getSocialCreditScore());
        existingHumineral.get().setLastUpdatedAt(new Date(System.currentTimeMillis()));
        return humineralRepository.save(existingHumineral.get());
    }

    @Override
    public Boolean deleteById(String id) {
        humineralRepository.deleteById(id);
        return humineralRepository.findById(id).isEmpty();
    }

    @Override
    public Humineral getById(String humineralId) {
        return humineralRepository.findById(humineralId).orElseThrow(
                () -> new RuntimeException(String.format("No Humineral found for id: %s", humineralId)));
    }

    @Override
    public List<Humineral> getByName(String name) {
        return humineralRepository.findByName(name);
    }

    @Override
    public List<Humineral> getByFather(String father) {
        return humineralRepository.findByFather(father);
    }

    @Override
    public List<Humineral> getByMother(String mother) {
        return humineralRepository.findByMother(mother);
    }

    @Override
    public List<Humineral> getByNationality(String nationality) {
        return humineralRepository.findByNationality(nationality);
    }

    @Override
    public List<Humineral> getBySocialCreditScore(int score) {
        return humineralRepository.findBySocialCreditScore(score);
    }

    @Override
    public List<Humineral> getAll() {
        return humineralRepository.findAll();
    }
}
