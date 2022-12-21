package progammers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Year2016 {
    public static void main(String[] args) throws ParseException {
        int a = 5;
        int b = 24;
        String k = "0523";
        System.out.println(Integer.parseInt(k));
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(2016);
        sb.append("-");
        sb.append(a);
        sb.append("-");
        sb.append(b);
        String date2 = sb.toString();
        System.out.println(sb);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date ndate = dateFormat.parse(date2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(ndate);
        int dayNum = cal.get(Calendar.DAY_OF_WEEK);

        switch(dayNum){
            case 1:
                answer = "SUN";
                break ;
            case 2:
                answer = "MON";
                break ;
            case 3:
                answer = "TUE";
                break ;
            case 4:
                answer = "WED";
                break ;
            case 5:
                answer = "THU";
                break ;
            case 6:
                answer = "FRI";
                break ;
            case 7:
                answer = "SAT";
                break ;

        }
        System.out.println(answer);

    }
}
