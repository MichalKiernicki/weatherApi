package pl.sda.projekt.praktyczny.weather_app.http;

import com.google.gson.Gson;
import com.mashape.unirest.http.ObjectMapper;

public class ObjectMapperGsonImpl implements ObjectMapper {

    private final Gson gson;

    public ObjectMapperGsonImpl() {
        gson = new Gson();
    }

    @Override
    public <T> T readValue(String s, Class<T> aClass) {
        return gson.fromJson(s,aClass);
    }

    @Override
    public String writeValue(Object o) {
        return gson.toJson(o);
    }
}
