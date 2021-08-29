package pl.sda.projekt.praktyczny.weather_app.model;

import lombok.Data;

@Data
public class OpenWeatherMap {
    private String name;
    private OpenWeatherMapMain main;
    private OpenWeatherMapCoord coord;
    private OpenWeatherMapSys sys;
}
