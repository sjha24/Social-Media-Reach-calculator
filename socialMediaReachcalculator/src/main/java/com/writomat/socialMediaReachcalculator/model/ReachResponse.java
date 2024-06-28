package com.writomat.socialMediaReachcalculator.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReachResponse {
    private Integer impressions;
    private Integer reach;
}
