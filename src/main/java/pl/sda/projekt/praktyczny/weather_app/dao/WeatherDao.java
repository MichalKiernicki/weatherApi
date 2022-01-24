package pl.sda.projekt.praktyczny.weather_app.dao;

import pl.sda.projekt.praktyczny.weather_app.entity.Weather;

import java.time.LocalDate;
import java.util.List;

public interface WeatherDao {

    void save(Weather weather);
    void saveAll(Weather ... weathers);


    List<Weather> findByCityAndDate(String city, LocalDate date);
}
