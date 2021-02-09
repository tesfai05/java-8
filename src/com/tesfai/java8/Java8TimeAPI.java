package com.tesfai.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.TimeZone;

public class Java8TimeAPI {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		
		//OffsetDate, OffsetTime, and OffsetDateTime. 
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		
		HashMap<String, String> aliasMap = new HashMap<>();
		
	    aliasMap.put("EST", "America/New_York");
	    ZoneId zoneId = ZoneId.of("EST", aliasMap);
	    System.out.println(zoneId);
	    
	    ZoneId z = ZoneId.of("America/Phoenix");
	    
	    System.out.println(z);
	    
	   
	    LocalTime date1 = LocalTime.now(z);
	  
	    System.out.println(date1);
	    
	    
	    boolean isIsraelInDST = TimeZone.getTimeZone("America/Phoenix").useDaylightTime();
	    System.out.println(isIsraelInDST);
	    
	    ZoneId t1 = ZoneId.of("Pacific/Auckland" )   // Specify a time zone.
	    .getRules()                   // Get the object representing the rules for all the past, present, and future changes in offset used by the people in the region of that zone.
	    .getOffset( Instant.now());  // Get a `ZoneOffset` object representing the number of hours, minutes, and seconds displaced from UTC. Here we ask for the offset in effect right now.
	                      // Generate a String in standard ISO 8601 format.

		System.out.println(t1); 
		
		ZoneId t2 = ZoneId.of( "Pacific/Auckland" )
	    .getRules()
	    .getOffset( 
	        LocalDate.of( 2020 , Month.NOVEMBER , 9 )          // Specify a certain date. Has no concept of time zone or offset.
	        .atStartOfDay( ZoneId.of( "Pacific/Auckland" ) )  // Determine the first moment of the day on that date in that region. Not always `00:00:00` because of anomalies such as Daylight Saving Time.
	        .toInstant()                                      // Adjust to UTC by extracting an `Instant`. 
	    ) 
	    ;

		System.out.println(t2);
	}
}
