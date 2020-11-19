/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.timeformat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 *
 * @author michaelrodriguez
 */
public class TimeFormat {

    public static void main(String[] args) {
        
        //FORMATTING DATES 

        Integer x = 5;
        LocalDateTime myDate = LocalDateTime.now();

        //Below the format will look likes this ---> 02-15-2020 01:12:35
        String currentDate = myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss"));
        String xString = x.toString();
        System.out.println(currentDate);

//      Below the format will look likes this --->  2020-02-07
        LocalDate ld = LocalDate.parse("02/07/2020", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);

//      Below the format will look likes this --->  2020-01-26
        LocalDate past = ld.minusDays(12);
        System.out.println(past);

//       Below the format will look likes this --->  P-12D
        Period diff = ld.until(past);
        System.out.println(diff);

        // Its important to note when parsing : 
        // Make Sure that there arent any spaces in between the quotations. 
        // Below the format will look likes this --->   02/07/2020
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate lDate = LocalDate.parse("02/07/2020", formatter);
        String formatted = lDate.format(formatter);
        System.out.println(formatted);

        //Below the format will look likes this --->  02/%:07/%:2020/%:
        formatted = ld.format(DateTimeFormatter.ofPattern("MM/%:dd/%:yyyy/%:"));
        System.out.println(formatted);

        //Below the format will look likes this --->  Sunday, January 26, 2020
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        // Converting Date Object
        // The Conversion of a legacy Date oobject into LocalDate object 
        
        // 1st Step :
        // We convert the Date nto an Instant. Essentially , we are converting
        // the Date from human time into machine time. 
        
        // 2nd Step : 
        // We convert the Instant derived from legacy Date into a ZonedDateTime object using
        // the static ofInstant method. Here we are essentially converting the machine
        // time Instant back into huan time ZonedDateTime object. 
        // We need to pass a time zone id into the ofInstant method - we use the system defualt 
        // of the machine the code is running on . 
        
        Date legacyDate = new Date(); 
        ZonedDateTime zdt = ZonedDateTime.of(myDate, legacyDate);
        System.out.println(zdt);
        
        
        
        
        
    }
}
