package Jan28;

import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZones {
    public static void main(String[] args) {
        // Get the current time in GMT, IST, and PST
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Display the times in each time zone
        System.out.println("Current time in GMT: " + gmtTime);
        System.out.println("Current time in IST: " + istTime);
        System.out.println("Current time in PST: " + pstTime);
    }
}

