package pl.sda.projekt.praktyczny.weather_app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WEATHER_ITEMS")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private LocalDate date;
    private Long id;
    private Double lon;
    private Double lat;
    private String country;
    private String city;
    private Double temp;
    private Double pressure;
    private Double temp_min;
    private Double temp_max;
}
