package com.mapsa.dao;

import com.mapsa.model.P;

public interface PDao {
    P getPById(long id);
    void addP(P p);
    void editP(P p);
    void deleteP(P p);
}
