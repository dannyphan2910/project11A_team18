package calendar;

import java.util.*;

// javac -cp ".:SimpleTTS.jar" CalendarFunction.java
// java -cp ".:SimpleTTS.jar" CalendarFunction

<<<<<<< HEAD
public class CalendarFunction {
  //current date
  public static void currentDate() {
    Calendar calendar = Calendar.getInstance();
    System.out.println("The current date is: " + calendar.getTime());
=======
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
>>>>>>> ffa3fa529751e5f3d48c2095b71989c92a026926
  }
  /*
  //future or past day
  public static void futureDay(int n) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, n);
    if (n>0) {
      System.out.println("The date " + n + " days later is: " + calendar.getTime());
    } else {
      System.out.println("The date " + Math.abs(n) + " days ago is: " + calendar.getTime());
    }
  }

  //future or past month
  public static void futureMonth(int n) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, n);
    if (n>0) {
      System.out.println("The date " + n + " months later is: " + calendar.getTime());
    } else {
      System.out.println("The date " + Math.abs(n) + " months ago is: " + calendar.getTime());
    }
  }

  //future or past year
  public static void futureYear(int n) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, n);
    if (n>0) {
      System.out.println("The date " + n + " years later is: " + calendar.getTime());
    } else {
      System.out.println("The date " + Math.abs(n) + " years ago is: " + calendar.getTime());
    }
  }
  */

}
