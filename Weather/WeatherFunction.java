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
  
  public static void getWeather(String location) {
    Weather weather = locationForWeather(location);

    System.out.println(weather.weather.get(0).description.toUpperCase());
    System.out.printf("The temperature is %.2f °C (%.2f °F) %n",
                      kelvinToCelcius(weather.main.temp),
                      kelvinToFahrenheit(weather.main.temp));
    System.out.printf("The pressure: %.2f hPa %n",weather.main.pressure);
    System.out.printf("The humidity: %.2f percent %n",weather.main.humidity);
    System.out.printf("The maximum temperature: %.2f °C (%.2f °F) %n",
                      kelvinToCelcius(weather.main.temp_max),
                      kelvinToFahrenheit(weather.main.temp_max));
    System.out.printf("The minimum temperature: %.2f °C (%.2f °F) %n",
                      kelvinToCelcius(weather.main.temp_min),
                      kelvinToFahrenheit(weather.main.temp_min));
    System.out.printf("The wind speed: %.2f kph %n",weather.wind.speed);
  }

  public static Weather locationForWeather(String location) {
    location = location.replaceAll("\\s+","");
    String APIKey = "50304844df23acee48676e4583aaf195";
    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + APIKey;

    String json = getStringFromURL(url);
    Gson gson = new Gson();
    Weather weather = gson.fromJson(json,Weather.class);

    return weather;
  }

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
}

class Weather{
  List<WeatherJson> weather;
  MainJson main;
  WindJson wind;
}

class WeatherJson {
  String description;
}

class MainJson {
  double temp;
  double pressure;
  double humidity;
  double temp_min;
  double temp_max;
}

class WindJson {
  double speed;
}
