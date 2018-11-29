package weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import com.google.gson.Gson;
import java.util.*;

// javac -cp ".:gson-2.8.5.jar:SimpleTTS.jar" WeatherFunction.java
// java -cp ".:gson-2.8.5.jar:SimpleTTS.jar" WeatherFunction

public class WeatherFunction {
  /*
  public static void main(String[] args) {
    // for testing only!!
    SimpleTTS.say("This is the weather function application. It allows you to find the current weather of a city.");
    pause(6000);
    String input = promptForInput("Please enter the location: ");
    getWeatherCelcius(input);
  }
  */

  public static void getWeatherCelcius(String location) {
    Weather weather = locationForWeather(location);

    System.out.println(weather.weather.get(0).description.toUpperCase());
    System.out.printf("The temperature is %.2f degrees Celcius. %n",kelvinToCelcius(weather.main.temp));
    System.out.printf("The pressure: %.2f hPa %n",weather.main.pressure);
    System.out.printf("The humidity: %.2f percent %n",weather.main.humidity);
    System.out.printf("The maximum temperature: %.2f °C %n",kelvinToCelcius(weather.main.temp_max));
    System.out.printf("The minimum temperature: %.2f °C %n",kelvinToCelcius(weather.main.temp_min));
    System.out.printf("The wind speed: %.2f kph %n",weather.wind.speed);
    SimpleTTS.say("The current weather is " + weather.weather.get(0).description + " in " + location);
    pause(3000);
    SimpleTTS.say("with the temperature of " + (int)kelvinToCelcius(weather.main.temp) + "degrees Celcius.");
  }

  public static void getWeatherFahrenheit(String location) {
    Weather weather = locationForWeather(location);

    System.out.println(weather.weather.get(0).description.toUpperCase());
    System.out.printf("The temperature is %.2f degrees Fahrenheit. %n",kelvinToFahrenheit(weather.main.temp));
    System.out.printf("The pressure: %.2f hPa %n",weather.main.pressure);
    System.out.printf("The humidity: %.2f percent %n",weather.main.humidity);
    System.out.printf("The maximum temperature: %.2f °C %n",kelvinToFahrenheit(weather.main.temp_max));
    System.out.printf("The minimum temperature: %.2f °C %n",kelvinToFahrenheit(weather.main.temp_min));
    System.out.printf("The wind speed: %.2f kph %n",weather.wind.speed);
    SimpleTTS.say("The current weather is " + weather.weather.get(0).description + " in " + location);
    pause(3000);
    SimpleTTS.say("with the temperature of " + (int)kelvinToCelcius(weather.main.temp) + "degrees Fahrenheit.");
  }


  public static Weather locationForWeather(String location) {
    //user will input city name (no spaces) -> input checking
    location = location.replaceAll("\\s+","");
    String APIKey = "50304844df23acee48676e4583aaf195";
    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + APIKey;

    String json = getStringFromURL(url);
    Gson gson = new Gson();
    Weather weather = gson.fromJson(json,Weather.class);

    return weather;
  }

  //modify this when free
  public static String getStringFromURL(String myURL) {
    StringBuilder sb = new StringBuilder();
    URLConnection urlConn = null;
    InputStreamReader in = null;
    try {
      URL url = new URL(myURL);
      urlConn = url.openConnection();
      if (urlConn != null)
      urlConn.setReadTimeout(60 * 1000);
      if (urlConn != null && urlConn.getInputStream() != null) {
        in = new InputStreamReader(urlConn.getInputStream(),
        Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(in);
        if (bufferedReader != null) {
          int cp;
          while ((cp = bufferedReader.read()) != -1) {
            sb.append((char) cp);
          }
          bufferedReader.close();
        }
      }
      in.close();
    } catch (Exception e) {
      throw new RuntimeException("Exception while calling URL:"+ myURL, e);
    }

    return sb.toString();
  }

  public static double kelvinToCelcius(double kel) {
    return kel - 273;
  }

  public static double kelvinToFahrenheit(double kel) {
    return (9/5)*(kel - 273) + 32;
  }

  /**
  * speak the English words in the prompt, print a "> ", read and return response
  * @param prompt the sentence that should be spoken
  * @return the string that the user enters after hearing the prompt
  */
  public static String promptForInput(String prompt){
    SimpleTTS.say(prompt);
    System.out.print("> ");
    Scanner input = new Scanner(System.in);
    String response = input.nextLine();
    return response;
  }

  /**
  * this pauses for a given number of milliseconds
  * @param ms the number of millisecods to pause
  */
  public static void pause(int ms){
    try{
      java.lang.Thread.sleep(ms);
    } catch (Exception e){
      System.out.println("Exception while in pause method: "+e);
    }
  }

}

class Weather{
  List<WeatherJson> weather;
  MainJson main;
  WindJson wind;
}

class WeatherJson {
  String description; //somehow give advice
}

class MainJson {
  double temp; //say this
  double pressure;
  double humidity;
  double temp_min;
  double temp_max;
}

class WindJson {
  double speed;
}
