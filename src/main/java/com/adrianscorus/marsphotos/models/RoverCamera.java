package com.adrianscorus.marsphotos.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoverCamera {
    private String name;
    @JsonProperty("full_name")
    private String fullName;
}
