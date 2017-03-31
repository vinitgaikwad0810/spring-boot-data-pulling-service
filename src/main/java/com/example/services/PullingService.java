package com.example.services;

import com.example.dao.ObservationDao;
import com.example.dto.ObservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by vinit on 3/31/17.
 */
@Component
public class PullingService {

    @Autowired
    ObservationDao observationDao;


    public List<ObservationDto> pullRateOfUnemployment(String fromYear, String endYear) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");

        try {
            Date from = simpleDateFormat.parse(fromYear);
            Date to = simpleDateFormat.parse(endYear);
             return observationDao.pull("UNRATE", from, to);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
