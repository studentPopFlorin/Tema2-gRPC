import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Main {
    public static boolean isBirthDateValid(String birthDate) {
       /* int day=Integer.parseInt(birthDate.substring(0,2));
        int month=Integer.parseInt(birthDate.substring(3,5));
        int year=Integer.parseInt(birthDate.substring(6,10));
        LocalDate date=LocalDate.of(year,month,day);
        if(date.isAfter(ChronoLocalDate.from(LocalDate.now())))
        {
            return false;
        }*/

        try {
            LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("M/d/uuuu").withResolverStyle(ResolverStyle.STRICT));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String birthDate;
        Scanner in=new Scanner(System.in);
        birthDate=in.next();
    }
}
