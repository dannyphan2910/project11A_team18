package main;

import java.util.*;
import calendar.*;
import weather.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import com.google.gson.Gson;
import java.util.*;

public class MainCall {
  public static String[] calculatorWords = {"Sum", "Add", "Plus", "Total", "Subtract", "Calculate", "Equal", "Math", "-", "+", "*", "/", "Decrease", "Deduct", "Multiply", "Product", "Division", "Divide", "Greatest Common Denominator", "GCD", "LCD", "Lowest Common Denominator", "The average of", "Power", "Exponent", "Raised to", "Calculation", "Calculator"};
  public static String[] weatherWords = {"Climate", "Temperature", "Celcius", "Farenheit", "Rainy", "Rain", "Clouds", "Cloudy", "Sun", "Sunny", "Sunblock", "Wind", "Weather", "Precipitation", "Pressure", "Fog", "Foggy", "Snow", "Wind", "Windy", "Humidity", "Humid", "Rainfall", "Blizzard", "Atmosphere", "Winter", "Summer", "Fall"};
  public static String[] calendarWords = {"Date", "Day", "Decade", "Annual", "Age", "Minute", "Second", "Year", "Time", "Month", "Calendar", "Schedule", "Daytime", "Night Time", "Afternoon", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "2018"};

  public static String[] howAreYouWords = {"How are you", "How are you doing", "Are you well"};
  public static String[] jokesWords = {"Tell me a joke", "Say a joke", "What's a good joke?"};
  public static String[] whereAreYouFromWords = {"Where are you from", "Where were you born", "Where did you grow up","Where do you live","Where is your home","Where do you come from","Do you have a house"};
  public static String[] helloWords = {"Hello", "Hey", "Hi", "Greetings", "What’s up", "Sup", "Bonjour","Hola","Namaste","How do you do","Nice to meet you"};

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = "";

    introduction();

    System.out.print("👉  ");
    input = scan.nextLine();
    System.out.println();

    while (!(input.contains("Goodbye Ollie")) {

      if (checkInput(helloWords,input)) {

        System.out.println("Hey, you! 😎  Thanks for the greetings!  🦉");

      } else if (checkInput(howAreYouWords,input)) {

        System.out.println("I am great! Just living the owl life ya feel?  🦉  Thanks for asking! 😚");

      } else if (checkInput(whereAreYouFromWords,input)) {

        System.out.println("I was born in Farber Lib  📚 , but I now live EVERYWHERE  👀");

      } else if (checkInput(jokesWords,input)) {

      	System.out.println("Where is Macau located?");
        System.out.println("Mafarm.");
        System.out.println("Hahaha I'm so funny!  😂");

      } else if (checkInput(weatherWords,input)) {

        System.out.println("Please give Ollie the city's name: ");
        String cityName = scan.nextLine();
        System.out.println();
        weather.WeatherFunction.getWeather(cityName);

      } else if (checkInput(calculatorWords,input)) {
        Scanner scanCalc = new Scanner(System.in);

        instructionCalc();
        System.out.println();
        int choice = scanCalc.nextInt();

        switch (choice) {
          case 1:
            System.out.println();
            calculator.BasicOp.doCalculation();
            break;
          case 2:
            Scanner scanCalc2 = new Scanner(System.in);
            instructionCalc2();
            System.out.println();
            char choice2 = scanCalc2.next().charAt(0);

            switch (choice2) {
              case 'a': calculator.ExpOp.pow(); break;
              case 'b': calculator.ExpOp.squareRoot(); break;
              default: System.out.println("Ollie does not understand. Try again.");
            }
            break;
          case 3:
            Scanner scanCalc3 = new Scanner(System.in);
            instructionCalc3();
            System.out.println();
            char choice3 = scanCalc3.next().charAt(0);

            switch (choice3) {
              case 'a': calculator.AdvancedOp.factorial(); break;
              case 'b': calculator.AdvancedOp.primeCheck(); break;
              case 'c': calculator.AdvancedOp.GCD(); break;
              case 'd': calculator.AdvancedOp.LCM(); break;
              default: System.out.println("Ollie does not understand. Try again.");
            }
            break;
          default: System.out.println("Ollie does not understand. Try again.");
        }

      } else if (checkInput(calendarWords,input)) {
        Scanner scanCalendar = new Scanner(System.in);
        instructionCalendar();
        System.out.println();
        int choice = scanCalendar.nextInt();

        int num;

        switch (choice) {
          case 1:

            calendar.CalendarFunction.currentDate();

            break;
          case 2:
            System.out.println("Please give Ollie the number of days: ");
            num = scanCalendar.nextInt();

            calendar.CalendarFunction.futureDay(num);
            break;
          case 3:
            System.out.println("Please give Ollie the number of months: ");
            num = scanCalendar.nextInt();

            calendar.CalendarFunction.futureMonth(num);
            break;
          case 4:
            System.out.println("Please give Ollie the number of years: ");
            num = scanCalendar.nextInt();

            calendar.CalendarFunction.futureYear(num);
            break;
          default: System.out.println("Ollie does not understand. Try again.");
        }

      } else {
        search.SearchFunction.search(input);
      }

      System.out.println();

      System.out.print("👉  ");
      input = scan.nextLine();
      System.out.println();
    }
  }

  public static boolean checkInput(String[] list, String line) {
    for (int i = 0; i < list.length ; i++) {
      if (line.contains(list[i]) || line.contains(list[i].toLowerCase()) || line.contains(list[i].toUpperCase())) {
        return true;
      }
    }
    return false;
  }

  public static void introduction() {
    System.out.println("__________________________________________________________________");
    System.out.println();
    System.out.println("👋🏼  Hello, I'm Ollie the Owl 🦉  + 🤖  Your new personal assistant!");
    System.out.println();
    System.out.println(" I can help you out on things like : ");
    System.out.println();
    System.out.println("    Doing Calculations  🔢 ");
    System.out.println("    Checking the Calendar/Date  📆 ");
    System.out.println("    Checking the Weather  💦  🌤 ");
    System.out.println("    Google Search  💻  🔎 ");
    System.out.println();
    System.out.println("👋🏼  To exit my program simply type 'Goodbye Ollie' (case (very) sensitive!) 👋🏼 ");
    System.out.println();
    System.out.println(" For more information check our company page DYI Code, INC © : ");
    System.out.println("     https://github.com/dannyphan2910/project11A_team18        ");
    System.out.println("__________________________________________________________________");
  }

  public static void instructionCalc() {
    System.out.println("__________________________________________________________________");
		System.out.println();
		System.out.println("💁🏻‍  YASSS, You have arrived at the calculator function  🔢");
		System.out.println();
		System.out.println("Enter the corresponding number for which operation you want to do:");
		System.out.println();
		System.out.println("[1] – Basic Operations ( ➕ , ➖ , ➗ , ✖️ )");
		System.out.println();
		System.out.println("[2] – Exponential Operations ");
		System.out.println();
		System.out.println("[3] – Advanced Operations ");
		System.out.println();
		System.out.println("__________________________________________________________________");
  }

  public static void instructionCalc2(){
    System.out.println("__________________________________________________________________");
    System.out.println();
    System.out.println("	[a] – Power ");
    System.out.println("	[b] - Square Root ");
    System.out.println();
    System.out.println("__________________________________________________________________");
  }


  public static void instructionCalc3(){
    System.out.println("__________________________________________________________________");
    System.out.println();
    System.out.println("	[a] - Factorial Calculation ");
    System.out.println("	[b] - Checking for Prime ");
    System.out.println("	[c] - Greatest Common Denominator ");
    System.out.println("	[d] - Least Common Multiplier ");
    System.out.println();
    System.out.println("__________________________________________________________________");
  }

  public static void instructionCalendar() {
    System.out.println("__________________________________________________________________");
    System.out.println();
    System.out.println("Hello cool thang  😎 , what calendar function do you want to find this fine day?  📆");
    System.out.println("  [1] - I forget, what day is it today?");
    System.out.println("  [2] - I want to inquire about a future day, please");
    System.out.println("  [3] - I want to inquire about a future month, please");
    System.out.println("  [4] - I want to inquire about a future year, please");
    System.out.println();
    System.out.println("It can be negative too if you beautiful being want to know about the past!  🔎  🔮");
    System.out.println();
    System.out.println("__________________________________________________________________");
  }

}
