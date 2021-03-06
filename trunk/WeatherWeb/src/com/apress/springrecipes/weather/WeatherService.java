package com.apress.springrecipes.weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {

    public List<TemperatureInfo> getTemperatures(String city, List<Date> dates);
}
