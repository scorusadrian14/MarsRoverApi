package com.adrianscorus.marsphotos.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;

@Data
public class Photo {
    private Long id;
    private Integer sol;
    private Camera camera;
    @JsonProperty("img_src")
    private String imgSrc;
    @JsonProperty("earth_date")
    private Date earthDate;
    private Rover rover;

}
