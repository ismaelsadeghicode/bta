package com.mapsa.spring_repository.data.flight;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Component
public class SearchFlightDto {
    private String destination,source;
    private Timestamp date;

    public Boolean destinationValidation(){

        return checkValidation(this.destination);
    }
    public Boolean destinationAndSourceValidation(){
                if( checkValidation(this.destination)& checkValidation(this.source))
                      return true;
                else
                      return false;
    }
    public Boolean sourceValidation(){

        return checkValidation(this.source);
    }
    private Boolean checkValidation(String exp){
      /* Pattern pattern = Pattern.compile("^[a-zA-Z]{2,}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.destination);
        boolean matchFound = matcher.find();
        return matchFound;*/
        if (exp!=null){
            if (exp.length()>1){return true;}else{return false;}
        }else{
            return false;
        }
    }

}
