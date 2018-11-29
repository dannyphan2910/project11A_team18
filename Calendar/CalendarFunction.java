package calendar;

import java.util.*;

// javac -cp ".:SimpleTTS.jar" CalendarFunction.java
// java -cp ".:SimpleTTS.jar" CalendarFunction

// current date
public class CalendarFunction{

  public static void main(String[] args) {
    //for testing
    currentDate();
    //futureDay(3);
    //futureDay(-3);
    //futureMonth(5);
    //futureYear(-2);
  }


  public static void currentDate() {
    Calendar calendar = Calendar.getInstance();
    System.out.println("The current date is: " + calendar.getTime());
    String[] split = calendar.getTime().toString().split("\\s+");
    String say = "The current date is: " + split[0] + " " + split[1] + " " + split[2] + " " + split[5];
    SimpleTTS.say(say);
  }
  /*
  //future or past day
  public static void futureDay(int n) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, n);
    String[] split = calendar.getTime().toString().split("\\s+");
    if (n>0) {
      System.out.println("The date " + n + " days later is: " + calendar.getTime());
      SimpleTTS.say("The date " + n + " days later is: " + split[0] + " " + split[1] + " " + split[2] + " " + split[5]);
    } else {
      System.out.println("The date " + Math.abs(n) + " days ago is: " + calendar.getTime());
      SimpleTTS.say("The date " + Math.abs(n) + " days ago is: " + split[0] + " " + split[1] + " " + split[2] + " " + split[5]);
    }
  }

  //future or past month
  public static void futureMonth(int n) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, n);
    String[] split = calendar.getTime().toString().split("\\s+");
    if (n>0) {
      System.out.println("The date " + n + " months later is: " + calendar.getTime());
      SimpleTTS.say("The date " + n + " months later is: " + split[0] + " " + split[1] + " " + split[2] + " " + split[5]);
    } else {
      System.out.println("The date " + Math.abs(n) + " months ago is: " + calendar.getTime());
      SimpleTTS.say("The date " + Math.abs(n) + " months ago is: " + split[0] + " " + split[1] + " " + split[2] + " " + split[5]);
    }
  }

  //future or past year
  public static void futureYear(int n) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, n);
    String[] split = calendar.getTime().toString().split("\\s+");
    if (n>0) {
      System.out.println("The date " + n + " years later is: " + calendar.getTime());
      SimpleTTS.say("The date " + n + " years later is: " + split[0] + " " + split[1] + " " + split[2] + " " + split[5]);
    } else {
      System.out.println("The date " + Math.abs(n) + " years ago is: " + calendar.getTime());
      SimpleTTS.say("The date " + Math.abs(n) + " years ago is: " + split[0] + " " + split[1] + " " + split[2] + " " + split[5]);
    }
  }
  */

}
