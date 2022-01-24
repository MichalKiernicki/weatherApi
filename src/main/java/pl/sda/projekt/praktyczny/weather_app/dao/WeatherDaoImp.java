package pl.sda.projekt.praktyczny.weather_app.dao;

import pl.sda.projekt.praktyczny.weather_app.entity.Weather;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class WeatherDaoImp implements WeatherDao{

    private final EntityManager entityManager;

    public WeatherDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Weather weather) {
        entityManager.getTransaction().begin();
        if (weather.getId() == null) {
            entityManager.persist(weather);
        } else {
            entityManager.merge(weather);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveAll(Weather... weathers) {

    }

    @Override
    public List<Weather> findByCityAndDate(String city, LocalDate date) {
        return null;
    }
}
