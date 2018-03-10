package com.example.demo.controller;

import com.example.demo.FlightDetails;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class FlightController {

    private Map<String, FlightDetails> flightMap;

    @PostConstruct
    public void setup(){
        flightMap = new HashMap<>();
    }

    @RequestMapping(value = "/flightDetails", method = RequestMethod.POST)
    public Boolean save(@RequestBody FlightDetails flightDetails){

        flightMap.put(flightDetails.getName(), flightDetails);

        return true;
    }

    @RequestMapping(value = "/flightDetails", method = RequestMethod.GET)
    public FlightDetails get(@RequestParam String name){

        return flightMap.get(name);
    }
}
