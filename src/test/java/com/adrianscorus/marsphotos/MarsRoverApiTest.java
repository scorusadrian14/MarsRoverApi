package com.adrianscorus.marsphotos;

import com.adrianscorus.marsphotos.models.NasaApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MarsRoverApiTest {

    @Test
    public void smallTest(){
//        System.out.println("this is a test");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NasaApiResponse> response=restTemplate.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2015-6-3&api_key=DEMO_KEY", NasaApiResponse.class);
        System.out.println(response.getBody());
    }

}
