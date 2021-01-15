package ro.mta.se.lab.utility.implementation;

import ro.mta.se.lab.utility.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


/**
 * Class defining the logger of the application
 *
 * @author Chirita Gabriela
 */
public class LoggerImpl implements Logger {


    /**
     * Method logData
     * Logs the searched data from the application.
     * @param city represents the city that is searched.
     * @param country represents the country that is searched.
     */
    @Override
    public void logData(String city,String country) {

        String textToAppend = "";
        String date = "";
        LocalDateTime now = LocalDateTime.now();
        String day = now.getDayOfWeek().toString().toLowerCase();
        day = day.substring(0, 1).toUpperCase() + day.substring(1);

        if(now.getHour() > 0 && now.getHour() < 12){
            date = day + ",  " + now.getHour() + ":" + now.getMinute() + " AM";
        }
        else{
            date = day + ",  " + now.getHour() + ":" + now.getMinute() + " PM";
        }

        textToAppend = "[" + date + "]---city ["+city+"] from country ["+country+"] has been searched.\n";
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("src/main/resources/inputFile/logger.txt", true));
            writer.write(textToAppend);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
