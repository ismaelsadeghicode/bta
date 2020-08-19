package com.mapsa.dao;

import com.mapsa.model.Information;

public interface InformationDao {
    Information getInformationById(long id);
    Information getInformationByAccountId(long id);
    void addInformation(Information information);
}
