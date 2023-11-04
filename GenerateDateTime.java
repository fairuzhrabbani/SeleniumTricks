import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateDateTime {
    public static void main(String[] args) {

        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = formatter.format(d);
        String splitter[] = date.split("-");
        String month_year = splitter[1];
        String day = splitter[0];
        String year = splitter[2];
        System.out.println(d);
        System.out.println(date);
        System.out.println(month_year);
        System.out.println(day);
        System.out.println(year);
    }
}
