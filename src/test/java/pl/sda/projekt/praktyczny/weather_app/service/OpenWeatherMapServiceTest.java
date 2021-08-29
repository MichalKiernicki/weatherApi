package pl.sda.projekt.praktyczny.weather_app.service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.*;
import pl.sda.projekt.praktyczny.weather_app.http.ObjectMapperGsonImpl;
import pl.sda.projekt.praktyczny.weather_app.model.OpenWeatherMap;

class OpenWeatherMapServiceTest {

    private  static OpenWeatherMapService service;

    //uruchomi się raz pred wszystkimi testami
    @BeforeAll
    static void setup() {
        Unirest.setObjectMapper(new ObjectMapperGsonImpl());
        service = new OpenWeatherMapService();
    }

    @AfterAll
    static void cleaning() {

    }

    @Test
    @DisplayName("test calling OpenWeather API")
    void test_calling_OpenWeatherMap_Api() throws UnirestException {

        final OpenWeatherMap weatherForRzeszow = service.getWeather("Rzeszów");

        Assertions.assertEquals(weatherForRzeszow.getName(),"Rzeszów");
        Assertions.assertNotNull(weatherForRzeszow.getCoord());
        Assertions.assertEquals(weatherForRzeszow.getSys().getCountry(),"PL");
        Assertions.assertTrue(weatherForRzeszow.getMain().getTemp() > 0.0);
    }
}