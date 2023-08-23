package com.adrianscorus.marsphotos.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NasaApiResponse {
     List<Photo> photos = new ArrayList<>();
}
