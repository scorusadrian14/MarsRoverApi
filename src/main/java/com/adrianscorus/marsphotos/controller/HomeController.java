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
    public String getHomeView(ModelMap model, Long userId) throws InvocationTargetException, IllegalAccessException {
        HomeDto homeDto = createHomeDto(userId);
        if(userId==null){
            homeDto= marsRoverApiService.save(homeDto);
        }else{
            homeDto=marsRoverApiService.findByUserId(userId);
        }
        NasaApiResponse roverData1 = marsRoverApiService.getRoverData(homeDto);
        model.put("roverData",roverData1);
        model.put("homeDto",homeDto);
        model.put("validCameras",marsRoverApiService.getValidCameras().get(homeDto.getRoverData()));
        if(Boolean.TRUE.equals(homeDto.getRememberPreferences()) && userId!=null){
            HomeDto defaultHomeDto= createHomeDto(userId);
            marsRoverApiService.save(defaultHomeDto);
        }
        return "index";
    }

    private static HomeDto createHomeDto(Long userId) {
        HomeDto homeDto= new HomeDto();
        homeDto.setRoverData("opportunity");
        homeDto.setSol(1);
        homeDto.setUserId(userId);
        return homeDto;
    }

    @PostMapping("/")
    public String postHomeView(HomeDto homeDto){
        homeDto= marsRoverApiService.save(homeDto);
        return "redirect:/?userId="+homeDto.getUserId();
    }
}
