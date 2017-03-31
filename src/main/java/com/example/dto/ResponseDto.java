package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * Created by vinit on 3/30/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {


    List<ObservationDto> observations;

    public List<ObservationDto> getObservations() {
        return observations;
    }


    public ResponseDto() {


    }

    public ResponseDto(List<ObservationDto> observations) {

        this.observations = observations;
    }


}
