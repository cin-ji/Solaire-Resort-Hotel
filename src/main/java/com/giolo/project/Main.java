package com.giolo.project;

import com.giolo.project.convertor.TimeConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        // load resource bundles in separate threads
        Thread lang_en = new Thread(() -> {
            ResourceBundle English = ResourceBundle.getBundle("lang", Locale.ENGLISH);
            // get messages from bundle
            String messageEn = English.getString("welcome");
            // display message from bundle
            System.out.println(messageEn);
        });

        Thread lang_fr = new Thread(() -> {
            ResourceBundle French = ResourceBundle.getBundle("lang", Locale.FRENCH);
            String messageFr = French.getString("welcome");
            System.out.println(messageFr);
        });
        lang_en.start();
        lang_fr.start();

        // set an example time for event
        String presentationTime = "2023-03-28T15:29:00";
        // convert event time to ET
        String ET = TimeConverter.convertTime(presentationTime, "America/New_York", "America/New_York");
        // convert event time to MT
        String MT = TimeConverter.convertTime(presentationTime, "America/New_York", "America/Denver");
        // convert event time to UTC
        String UTC = TimeConverter.convertTime(presentationTime, "America/New_York", "UTC");
        System.out.println("Online Live Presentation Times:");
        System.out.println(ET + " ET");
        System.out.println(MT + " MT");
        System.out.println(UTC + " UTC");
    }
}
