package com.example.services;

import com.example.dao.ObservationDao;
import com.example.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vinit on 3/31/17.
 */
@Component
public class StoringService {

    @Autowired
    ObservationDao observationDao;

    @Autowired
    FREDServiceClientService fredServiceClientService;

    public void pullAndStoreData(String series_id) {

        ResponseDto responseDto = fredServiceClientService.retrieveFREDDataSeries(series_id, "avg", "a");


        observationDao.store(responseDto.getObservations(), series_id);

    }

    public void clear() {

        observationDao.clear();
    }


}

