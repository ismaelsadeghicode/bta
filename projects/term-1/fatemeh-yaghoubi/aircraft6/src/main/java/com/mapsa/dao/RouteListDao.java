package com.mapsa.dao;

import com.mapsa.model.Routelists;
import java.util.List;

public interface RouteListDao {
    List<Routelists> findAllRouteList();
    Routelists getRouteListById(long id);
    void addRouteList(Routelists routeList);
    void editeRouteList(Routelists routeList);
    void delete(Routelists routeList);
}