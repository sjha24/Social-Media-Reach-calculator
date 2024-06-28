package com.writomat.socialMediaReachcalculator.service;
import com.writomat.socialMediaReachcalculator.model.ReachRequest;
import com.writomat.socialMediaReachcalculator.model.ReachResponse;
import org.springframework.stereotype.Service;



@Service
public class SocialReachCalculatorService {
    private static final double AVERAGE_IMPRESSION_RATE = 0.2; // 20%
    private static final double AVERAGE_REACH_RATE = 0.15; // 15%
    public ReachResponse process(ReachRequest request) {
        int followers = request.getFollowers();
        int impressions = (int) (followers * AVERAGE_IMPRESSION_RATE);
        int reach = (int) (followers * AVERAGE_REACH_RATE);
        return new ReachResponse(impressions, reach);
    }
}
