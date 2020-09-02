package com.mapsa.controller.flight;
import com.mapsa.models.Flight;
import com.mapsa.services.account.AccountService;
import com.mapsa.services.account.CustomExeption;
import com.mapsa.services.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Controller
public class Index {

    @Autowired
    FlightService flightService;
    @Autowired
    AccountService accountService;



@RequestMapping("/")
    public String index(Model model){
       Flight flight=new Flight();
      // flight.setId(new Long(78));
        flight.setName("illam to tehran");
        flight.setCompany("homa");
        flight.setAirplaneSeatNumber(3);
       flight.setDestination("KARBLA");
       flight.setOrigin("ILAM");
       flight.setFee(500000);
       flight.setFlightDate(new Timestamp(1));
       flight.setArivalDate(new Timestamp(6));
       flight.setDescription("airplane class very god and type A");
    flightService.createFlight(flight);
    flight.setDestination("ilam");
    flight.setOrigin("tehran");
    flightService.createFlight(flight);
    flight.setDestination("ghom");
    flight.setOrigin("mashhad");
    flightService.createFlight(flight);

       List<Flight> flightList=flightService.getFlightList();
       if(flightList.size()>0){
           System.out.println("flightList Size is:"+flightList.size());
       }else{
           System.out.println("flightList Size is:  0");
       }

       model.addAttribute("Flights",flightList);
    return "index";
}
@RequestMapping("/flightDetails/{id}")
    public String flightDetails(@PathVariable long id,Model model){

    Flight flight= flightService.getFlightById(id);
    model.addAttribute("flight",flight);
    return "flightDetails";
}


@RequestMapping("/flightSearch")
public String flightSearch(Model model, @RequestBody() String dest_origin){
    //List<Flight> flightList=flightService.getFlightByDestinationAndOrigin(destination,origin);
    List<Flight> flightList=new ArrayList<>();
    try{
      flightList=flightService.getFlightByDestination(dest_origin);
        model.addAttribute("Flights",flightList);
        return "index";
    }catch (CustomExeption e){
        model.addAttribute("error",e.getMessage());
        return "error";
    }


}
}
