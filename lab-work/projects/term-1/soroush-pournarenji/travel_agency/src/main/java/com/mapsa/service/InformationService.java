package com.mapsa.service;

import com.mapsa.dao.InformationDao;
import com.mapsa.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    @Autowired
    InformationDao informationDao;

    public Information getInformationByAccountId(long id) {
        Information information = informationDao.getInformationByAccountId(id);
        if (information == null) {
            information = new Information();
            information.setAccountId(id);
        }
        return information;
    }

    public void addOrEditInformation(Information information) {
        informationDao.addOrUpdateInformation(information);
    }
}
