package com.adrianscorus.marsphotos.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mars_preferences")
public class HomeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String roverData;
    private Integer sol;
    private Boolean cameraFhaz;
    private Boolean cameraRhaz;
    private Boolean cameraMast;
    private Boolean cameraChemcam;
    private Boolean cameraMahli;
    private Boolean cameraMardi;
    private Boolean cameraNavcam;
    private Boolean cameraPancam;
    private Boolean cameraMinites;
    private Boolean rememberPreferences;

}
