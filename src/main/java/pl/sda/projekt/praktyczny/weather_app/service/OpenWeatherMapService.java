package pl.sda.projekt.praktyczny.weather_app.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import pl.sda.projekt.praktyczny.weather_app.model.OpenWeatherMap;
import pl.sda.projekt.praktyczny.weather_app.model.OpenWeatherMapMain;

public class OpenWeatherMapService {
    public final static String APP_ID = "d76fed5fee57c368654ffb0e773afad7";

    public OpenWeatherMap getWeather(String city) throws UnirestException {


        //Rest version
        //GET -> pobiernie

        final OpenWeatherMap weatherForSelectedCity = Unirest.get("https://api.openweathermap.org/data/2.5/weather")
                .queryString("q",city)
                .queryString("appid",APP_ID)
                .queryString("units","metric")
                .asObject(OpenWeatherMap.class)
                .getBody();

        return weatherForSelectedCity;
    }
}
