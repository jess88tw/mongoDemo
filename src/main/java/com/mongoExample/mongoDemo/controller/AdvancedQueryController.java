package com.mongoExample.mongoDemo.controller;

import com.mongoExample.mongoDemo.controller.rs.Humineral;
import com.mongoExample.mongoDemo.service.HumineralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/huminerals")
@Api(tags = "Humineral Operation Advanced Query APIs")
public class AdvancedQueryController {

    private final HumineralService humineralService;

    @ApiOperation(
            value = "Get Humineral by Social Credit Score and Nationality",
            notes = "Query Humineral based on the country and a Social Credit Score greater than the input"
    )
    @GetMapping("/getBySocialCreditScoreAndNationality")
    public List<Humineral> getBySocialCreditScoreAndNationality(
            @RequestParam int score,
            @RequestParam String nationality
    ) {
        return humineralService.getBySocialCreditScoreAndNationality(score, nationality);
    }

    @ApiOperation(
            value = "Get All Page of Humineral",
            notes = "Pageable Test"
    )
    @GetMapping("/getAllPages")
    public Page<Humineral> getAllPages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return humineralService.getAllPages(pageable);
    }
}
