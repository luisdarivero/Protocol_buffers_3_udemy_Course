import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;
import example.simple.Simple;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Example enums");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345);
        //Example with Enums
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);
        System.out.println(builder.toString());
    }

}
