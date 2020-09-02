package com.mapsa.services.flight;

import com.mapsa.dao.flight.IFlight;
import com.mapsa.dao.airplane_seat.IAirplaneSeat;
import com.mapsa.models.AirplaneSeat;
import com.mapsa.models.Flight;
import com.mapsa.services.account.ConstVariable;
import com.mapsa.services.account.CustomExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    IFlight flightDaoImpl;
    @Autowired
    IAirplaneSeat airplaneSeatDaoImpl;
    public List<Flight> getFlightList(){

       return flightDaoImpl.getFlightList();

    }
    public Flight getFlightById(long id){
        return flightDaoImpl.getFlightById(id);
    }
    public boolean createFlight(Flight flight){
        long flightId=flightDaoImpl.createFlight(flight);

        System.out.println( flightDaoImpl.getFlightById(flightId).getArivalDate());
        AirplaneSeat airplaneSeat=new AirplaneSeat();
        if(flightId>0){
            for(int i=0;i<flight.getAirplaneSeatNumber();i++) {
               airplaneSeat.setFLIGHT(flightDaoImpl.getFlightById(flightId));
                airplaneSeat.setSeatNumber(i+1);
                airplaneSeat.setStatus("0");
                airplaneSeatDaoImpl.createAirplanSeat(airplaneSeat);


            }
        }else{}
        return false;
    }
    boolean deleteFlightById(long id){return flightDaoImpl.deleteFlightById(id);}
    public List<Flight> getFlightByDestination(String dest_orogin) throws CustomExeption {
          String[] address=splithelper(dest_orogin);///////////address[0]=dest   and address[1]=origin
          if(address[0].equals("0")&address[1].equals("0")){
              throw new CustomExeption(ConstVariable.DESTINATION_AND_ORIGIN_IS_FREE);
          }else if(address[0].equals("0")){
              throw new CustomExeption(ConstVariable.DESTINATION_IS_FREE);
          }else if (address[1].equals("0")){
              return flightDaoImpl.getFlightByDestination(address[0]);
          }else {
              return flightDaoImpl.getFlightByDestinationAndSource(address[0],address[1]);
          }

    }

    private String[] splithelper(String dest_orogin) {
        String[] temp={"",""};

        String[] temp3={"",""};
        ///name=valu1&name=value2
        temp3=dest_orogin.split("&");
        String[] temp2=temp3[0].split("=");
        if(temp2.length>1)
        temp[0]=temp2[1];
        else temp[0]="0";
        ///////////////////
        String[] temp4=temp3[1].split("=");
        if(temp4.length>1)
            temp[1]=temp4[1];
        else temp[1]="0";
        return temp;

    }
    /*List<Flight> getFlightByDestinationAndDate(String destination, Date date){return flightDaoImpl.getFlightByDestinationAndDate(destination,date);}
   public List<Flight> getFlightByDestinationAndOrigin(String destination, String origin){
        //return flightDaoImpl.getFlightByDestinationAndSource(destination,origin);
       return flightDaoImpl.getFlightByDestination(destination);
    }*/


}
