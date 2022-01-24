package pl.sda.projekt.praktyczny.weather_app.dao;

import com.mashape.unirest.http.Unirest;
import org.junit.jupiter.api.*;
import pl.sda.projekt.praktyczny.weather_app.entity.Weather;
import pl.sda.projekt.praktyczny.weather_app.http.ObjectMapperGsonImpl;
import pl.sda.projekt.praktyczny.weather_app.service.OpenWeatherMapService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class WeatherDaoImplTest {

    private static EntityManagerFactory entityManagerFactory;

    @BeforeAll
    static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pl.sda.projekt.praktyczny.weather_app");

    }

    @AfterAll
    static void cleaning() {
        entityManagerFactory.close();
    }
    @DisplayName("Testing if Weathr object is proprly saved i database")
    @Test
    void saveWeather_notExistetInDB_savedInDB() {

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        WeatherDao weatherDao = new WeatherDaoImp(entityManager);
        Weather weather = new Weather();
        weather.setDate(LocalDate.now());
        weather.setCity("Rzeszów");
        weather.setTemp(20.00);

        weatherDao.save(weather);

        final List<Weather> weatherItems = entityManager
                .createQuery("SELECT w FROM Weather w WHERE city = :cityx", Weather.class)
                .getResultList();
        entityManager.close();
        Assertions.assertTrue(weatherItems.size() == 1);
        Assertions.assertEquals(weatherItems
                .stream()
        .findFirst()
        .get()
        .getCity(), "Rzeszów");


    }
    @DisplayName("Testing if Weather items are fetched from database using city and date query")
    @Test
    void findWeatherByCityAndDate_existedInDB_areReturned(){
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        WeatherDao weatherDao = new WeatherDaoImp(entityManager);
        final Weather weather1 = Weather.builder().city("Rzeszów").date(LocalDate.now()).temp(20.00).build();
        final Weather weather2 = Weather.builder().city("Rzeszów").date(LocalDate.now()).temp(21.00).build();
        final Weather weather3 = Weather.builder().city("Rzeszów").date(LocalDate.now()).temp(22.00).build();
        final Weather weather4 = Weather.builder().city("Rzeszów").date(LocalDate.now()).temp(23.00).build();
        final Weather weather5 = Weather.builder().city("Rzeszów").date(LocalDate.now()).temp(24.00).build();

        weatherDao.saveAll(weather1,weather2,weather3,weather4,weather5);

        final  List<Weather> weatherForRzeszow = weatherDao.findByCityAndDate("Rzeszów",LocalDate.now());

        final  List<Weather> weatherForKrakow = weatherDao.findByCityAndDate("Rzeszów",LocalDate.now());
        entityManager.close();
    }
}
