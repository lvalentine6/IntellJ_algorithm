package progammers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Year2016_2 {
    public static void main(String[] args) throws ParseException {
        int a = 5;
        int b = 24;
        String answer = "";

        LocalDate date = LocalDate.of(2016, a, b);
        answer = date.getDayOfWeek().toString().substring(0,3);

        System.out.println(answer);

    }
}
