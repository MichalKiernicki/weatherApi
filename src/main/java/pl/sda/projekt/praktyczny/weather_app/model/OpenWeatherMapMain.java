package pl.sda.projekt.praktyczny.weather_app.model;

import lombok.Data;

@Data
public class OpenWeatherMapMain {
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public double pressure;
}
