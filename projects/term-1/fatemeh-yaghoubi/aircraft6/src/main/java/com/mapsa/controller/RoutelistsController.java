package com.mapsa.controller;


import com.mapsa.dao.RouteListDao;
import com.mapsa.model.Routelists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public class RoutelistsController {
    @Autowired
    private RouteListDao routeListDao;


    @RequestMapping("/")
    public String index(){
        routeListDao.findAllRouteList();
        return "index";
    }

    @RequestMapping("/routelist")
    public String RoutList(  Model model){
        List<Routelists> routeLists=routeListDao.findAllRouteList();
        model.addAttribute(  "routeLists",routeLists.get(0));
        return "routeLists";
    }
    @RequestMapping("/RoutLists/{id}")
    public String RoutLists( @PathVariable long id ,Model model){
        Routelists routeList= routeListDao.getRouteListById( id );
        model.addAttribute( "FATEMEH",routeList);
        return "viewsroutLists";
    }

}
