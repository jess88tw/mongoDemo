package com.mongoExample.mongoDemo.controller;

import com.mongoExample.mongoDemo.controller.rq.HumineralPostRq;
import com.mongoExample.mongoDemo.controller.rq.HumineralUpdateRq;
import com.mongoExample.mongoDemo.controller.rs.Humineral;
import com.mongoExample.mongoDemo.service.HumineralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/huminerals")
@Tag(name = "Humineral Operation APIs", description = "API collection for CRUD operations on Humineral")
public class HumineralController {

    private final HumineralService humineralService;

    @Operation(
            summary = "Create a new Humineral",
            description = "{\n\n" +
                    "  \"name\": \"Jess\",\n\n" +
                    "  \"description\": \"soooooo lame\",\n\n" +
                    "  \"father\": \"Chen\",\n\n" +
                    "  \"mother\": \"Yang\",\n\n" +
                    "  \"nationality\": \"TW\",\n\n" +
                    "  \"socialCreditScore\": 100\n\n" +
                    "}",
            tags = "Humineral Operation APIs"
    )
    @PostMapping
    public Humineral createNew(@RequestBody HumineralPostRq postRq) {
        return humineralService.createNewHumineral(postRq);
    }

    @PutMapping
    public Humineral updateHumineral(@RequestBody HumineralUpdateRq updateRq) {
        return humineralService.updateHumineral(updateRq);
    }

    @DeleteMapping
    public Boolean deleteHumineral(@RequestParam String humineralId) {
        return humineralService.deleteById(humineralId);
    }

    @GetMapping("/getById")
    public Humineral getById(@RequestParam String humineralId) {
        return humineralService.getById(humineralId);
    }

    @GetMapping("/getByName")
    public List<Humineral> getByName(@RequestParam String name) {
        return humineralService.getByName(name);
    }

    @GetMapping("/getByFather")
    public List<Humineral> getByFather(@RequestParam String father) {
        return humineralService.getByFather(father);
    }

    @GetMapping("/getByMother")
    public List<Humineral> getByMother(@RequestParam String mother) {
        return humineralService.getByMother(mother);
    }

    @GetMapping("/getByNationality")
    public List<Humineral> getByNationality(@RequestParam String nationality) {
        return humineralService.getByNationality(nationality);
    }

    @GetMapping("/getBySocialCreditScore")
    public List<Humineral> getBySocialCreditScore(@RequestParam int score) {
        return humineralService.getBySocialCreditScore(score);
    }

    @GetMapping("/getAll")
    public List<Humineral> getAll() {
        return humineralService.getAll();
    }
}
