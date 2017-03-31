package com.example.controllers;

import com.example.dto.ObservationDto;
import com.example.services.PullingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by vinit on 3/30/17.
 */
@Controller
public class Greeting {


    @Autowired
    public PullingService pullingService;

    @RequestMapping("/average/rateOfEmployment")
    public
    @ResponseBody
    List<ObservationDto> averageRate(@RequestParam("from") String fromYear, @RequestParam("to") String toYear) {


        return pullingService.pullRateOfUnemployment(fromYear, toYear);

    }
}
