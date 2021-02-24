
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static java.util.Calendar.MONDAY;
import static java.util.Calendar.PM;

public class calendar_class {

    private static  boolean yearIsCorrect(int year){
        return year > 1800 && year <= 3999;
    }

    private static void generate_month(int year, int month){

        Calendar calendar = new GregorianCalendar(year, month, 01);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        //print month name and year
        System.out.println(new SimpleDateFormat("MMMM").format(calendar.getTime()));
        System.out.println(" Н  П  В  С  Ч  П  С ");

        //print initial spaces
        String initialSpace = "";
        for (int i = 0; i < dayOfWeek - 1; i++) {
            initialSpace += "   ";
        }
        System.out.print(initialSpace);

        //print the days of the month starting from 1
        for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
            for (int j = ((i == 0) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
                System.out.printf("%2d ", dayOfMonth);
                dayOfMonth++;
            }
            System.out.println();
        }
    }


    private static void generate_year (int year){
        //check if correct
        if(!yearIsCorrect(year)){
            System.out.println("Invalid year");
            return;
        }
        //print months
        for(int i = 0; i<12; i++){
            generate_month(year,i);
            System.out.println();
            System.out.println();
        }
    }

    public static void get_calendar(){
        //enter year
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose year: ");
        String year_in =  sc.nextLine();
        //print year
        generate_year(Integer.parseInt(year_in));
    }

    public static void main(String[] args) {
        get_calendar();
    }
}

