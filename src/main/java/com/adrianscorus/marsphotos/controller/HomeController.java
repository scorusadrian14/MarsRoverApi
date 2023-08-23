package com.adrianscorus.marsphotos.controller;

import com.adrianscorus.marsphotos.dto.HomeDto;
import com.adrianscorus.marsphotos.models.NasaApiResponse;
import com.adrianscorus.marsphotos.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {
    @Autowired
    private MarsRoverApiService marsRoverApiService;
    @GetMapping("/")
    public String getHomeView(HomeDto homeDto, ModelMap model) throws InvocationTargetException, IllegalAccessException {
        if(StringUtils.isEmpty(homeDto.getRoverData())){
            homeDto.setRoverData("opportunity");
        }
        if(homeDto.getSol()== null){
            homeDto.setSol(1);
        }
        NasaApiResponse roverData1 = marsRoverApiService.getRoverData(homeDto);
        model.put("roverData",roverData1);
        model.put("homeDto",homeDto);
        model.put("validCameras",marsRoverApiService.getValidCameras().get(homeDto.getRoverData()));
        return "index";
    }
    @PostMapping("/")
    public String postHomeView(HomeDto homeDto){
        System.out.println(homeDto);
        return "redirect:/";
    }
}
