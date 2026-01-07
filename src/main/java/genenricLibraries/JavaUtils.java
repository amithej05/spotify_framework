package genenricLibraries;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;


public class JavaUtils {

    /**
     * Generates a random integer between 0 and 499.
     * @return a random integer value
     */
    public int getRandom() {
        Random ran = new Random();
        int random = ran.nextInt(700);   // returns number within 0-499
        return random;
    }

    /**
     * Fetches today's system date in the format yyyy-MM-dd.
     * Example: 2025-12-08
     * @return formatted current date
     */
    public String systemDate() {
        LocalDate date = LocalDate.now();  // fetches today's date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String systemdate = formatter.format(date);
        return systemdate;
    }

    /**
     * Fetches the system date with time in the format dd-MM-yyyy HH:mm:ss.
     * Example: 08-12-2025 22:15:30
     * @return formatted date and time
     */
    public String sysdate() {
        Date date = new Date();  // current date and time
        SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String systemdateInFormat = sim.format(date);
        return systemdateInFormat;
    }

    /**
     * Calculates a future date based on the number of months added to the current date.
     * Returns date in dd-MM-yyyy format.
     * @param futureMon number of months to add
     * @return the future date in dd-MM-yyyy format
     */
    public String futureDateIntermsOfMonths(long futureMon) {
        LocalDate date = LocalDate.now();        // current date
        LocalDate future = date.plusMonths(futureMon);  // future date after adding months
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String futureMonth = formatter.format(future);
        return futureMonth;
    }
}