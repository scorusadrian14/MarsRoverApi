package com.adrianscorus.marsphotos.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Rover {
    private Long id;
    private String name;
    @JsonProperty("landing_date")
    private Date landingDate;
    @JsonProperty("launch_date")
    private Date launchDate;
    private String status;
    @JsonProperty("max_sol")
    private Integer maxSol;
    @JsonProperty("max_date")
    private Date maxDate;
    @JsonProperty("total_photos")
    private Long totalPhotos;
    @JsonProperty("cameras")
    private RoverCamera[] cameras;
}
