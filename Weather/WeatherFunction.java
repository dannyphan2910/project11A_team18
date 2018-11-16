import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import com.google.gson.Gson;

public class WeatherFunction {
  public static void main(String[] args) {
    Weather weather = locationForWeather("London");
    System.out.println("the temp is " + weather.main.temp);
    System.out.println(weather.weather.get(0).description);
  }

  public static Weather locationForWeather(String location) {
    //user will input city name (no spaces) -> input checking
    String APIKey = "50304844df23acee48676e4583aaf195";
    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + APIKey;
    //"https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";


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

//methods to convert Kelvin -> Celcius & Ferenheit (according to users' input)

}

class Weather{
  List<WeatherJson> weather;
  MainJson main;
  WindJson wind;
}

class WeatherJson {
  String description; //somehow give advice
  String main;
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
