package com.mongoExample.mongoDemo.controller;

import com.mongoExample.mongoDemo.controller.rq.HumineralPostRq;
import com.mongoExample.mongoDemo.controller.rq.HumineralUpdateRq;
import com.mongoExample.mongoDemo.controller.rs.Humineral;
import com.mongoExample.mongoDemo.service.HumineralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/huminerals")
@Api(tags = "Humineral Operation APIs")
public class HumineralController {

    private final HumineralService humineralService;

    @ApiOperation(
            value = "Create a new Humineral",
            notes = "{\n" +
                    "&nbsp;&nbsp;\"name\": \"Jess\",\n" +
                    "&nbsp;&nbsp;\"description\": \"soooooo lame\",\n" +
                    "&nbsp;&nbsp;\"father\": \"Chen\",\n" +
                    "&nbsp;&nbsp;\"mother\": \"Yang\",\n" +
                    "&nbsp;&nbsp;\"nationality\": \"TW\",\n" +
                    "&nbsp;&nbsp;\"socialCreditScore\": 100\n" +
                    "}"
    )
    @PostMapping
    public Humineral createNew(@RequestBody HumineralPostRq postRq) {
        return humineralService.createNewHumineral(postRq);
    }

    @ApiOperation(value = "Update Humineral Information")
    @PutMapping
    public Humineral updateHumineral(@RequestBody HumineralUpdateRq updateRq) {
        return humineralService.updateHumineral(updateRq);
    }

    @ApiOperation(value = "Delete a Humineral")
    @DeleteMapping
    public Boolean deleteHumineral(@RequestParam String humineralId) {
        return humineralService.deleteById(humineralId);
    }

    @ApiOperation(value = "Get Humineral by Id")
    @GetMapping("/getById")
    public Humineral getById(@RequestParam String humineralId) {
        return humineralService.getById(humineralId);
    }

    @ApiOperation(value = "Get Humineral by Name")
    @GetMapping("/getByName")
    public List<Humineral> getByName(@RequestParam String name) {
        return humineralService.getByName(name);
    }

    @ApiOperation(value = "Get Humineral by Father's name")
    @GetMapping("/getByFather")
    public List<Humineral> getByFather(@RequestParam String father) {
        return humineralService.getByFather(father);
    }

    @ApiOperation(value = "Get Humineral by Mother's name")
    @GetMapping("/getByMother")
    public List<Humineral> getByMother(@RequestParam String mother) {
        return humineralService.getByMother(mother);
    }


    @ApiOperation(value = "Get Humineral by Nationality")
    @GetMapping("/getByNationality")
    public List<Humineral> getByNationality(@RequestParam String nationality) {
        return humineralService.getByNationality(nationality);
    }

    @ApiOperation(value = "Get Humineral by Social Credit Score")
    @GetMapping("/getBySocialCreditScore")
    public List<Humineral> getBySocialCreditScore(@RequestParam int score) {
        return humineralService.getBySocialCreditScore(score);
    }

    @ApiOperation(value = "Get all Humineral")
    @GetMapping("/getAll")
    public List<Humineral> getAll() {
        return humineralService.getAll();
    }
}
