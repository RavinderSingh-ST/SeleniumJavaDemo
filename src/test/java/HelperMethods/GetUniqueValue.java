package HelperMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetUniqueValue {
    public static String getUniqueValue() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}