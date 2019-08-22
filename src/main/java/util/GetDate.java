package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GetDate {
    public static String getShipDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone("+0000"));
        return dateFormat.format(date);

    }
}
