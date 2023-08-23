package com.adrianscorus.marsphotos.service;

import com.adrianscorus.marsphotos.dto.HomeDto;
import com.adrianscorus.marsphotos.models.NasaApiResponse;
import com.adrianscorus.marsphotos.models.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MarsRoverApiService {
    private static final String DEMO_KEY ="ooGzFJQYz3X7JjhRe4sgAakVckqluv7rl1UkRsKh";
    private final Map<String, List<String>> validCameras= new HashMap<>();
    private static final String BASE_URL="https://api.nasa.gov/mars-photos/api/v1/rovers/";
    public MarsRoverApiService(){
        validCameras.put("opportunity", Arrays.asList("FHAZ","RHAZ","NAVCAM","PANCAM","MINITES"));
        validCameras.put("curiosity",Arrays.asList("FHAZ","RHAZ","MAST","MAHLI","CHEMCAM","MARDI","NAVCAM"));
        validCameras.put("spirit",Arrays.asList("FHAZ","RHAZ","NAVCAM","PANCAM","MINITES"));
    }
    public NasaApiResponse getRoverData(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        RestTemplate restTemplate = new RestTemplate();
        List<String> apiUrlsEndpoints= getApiUrlEndpoints(homeDto);
        List<Photo> photos = new ArrayList<>();
        NasaApiResponse response = new NasaApiResponse();
        apiUrlsEndpoints
                .forEach(url->{
                    NasaApiResponse apiResponse =restTemplate.getForObject(url,NasaApiResponse.class);
                    assert apiResponse != null;
                    photos.addAll(apiResponse.getPhotos());
                });
        response.setPhotos(photos);
        return  response;
    }
    public List<String> getApiUrlEndpoints(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        List<String> urls = new ArrayList<>();
        Method[] methods = homeDto.getClass().getMethods();
        for(Method method:methods){
            if(method.getName().contains("getCamera") && Boolean.TRUE.equals(method.invoke(homeDto))){
                String cameraName=method.getName().split("getCamera")[1].toUpperCase();
                if(validCameras.get(homeDto.getRoverData()).contains(cameraName)){
                    urls.add(BASE_URL+homeDto.getRoverData()+"/photos?sol="+homeDto.getSol()+"&api_key="+DEMO_KEY+"&camera="+cameraName);
                }
            }
        }
        return urls;
    }
    public Map<String, List<String>> getValidCameras(){
        return validCameras;
    }
}
