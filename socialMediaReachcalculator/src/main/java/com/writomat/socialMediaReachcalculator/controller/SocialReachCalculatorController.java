package com.writomat.socialMediaReachcalculator.controller;
import com.writomat.socialMediaReachcalculator.model.ReachRequest;
import com.writomat.socialMediaReachcalculator.model.ReachResponse;
import com.writomat.socialMediaReachcalculator.service.SocialReachCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
@CrossOrigin("*")
public class SocialReachCalculatorController {
    @Autowired
    SocialReachCalculatorService socialReachCalculatorService;

    @PostMapping("/calculate")
    public ReachResponse calculateReach(@RequestBody ReachRequest request){
        return socialReachCalculatorService.process(request);
    }
}
