package com.giolo.project.convertor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {
    public static String convertTime(String inputTime, String currentTime, String convertedTime) {
        LocalDateTime dateTime = LocalDateTime.parse(inputTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        ZoneId currentZone = ZoneId.of(currentTime);
        ZoneId convertedZone = ZoneId.of(convertedTime);
        ZonedDateTime currentZDT = dateTime.atZone(currentZone);
        ZonedDateTime convertedZDT = currentZDT.withZoneSameInstant(convertedZone);
        return convertedZDT.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}

