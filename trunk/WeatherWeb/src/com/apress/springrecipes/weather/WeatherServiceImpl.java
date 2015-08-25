package com.apress.springrecipes.weather;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(serviceName = "WeatherService")
public class WeatherServiceImpl implements WeatherService {

	// @Resource(name="myService")
	@Autowired
	private MyService myService;

	@WebMethod(operationName = "getTemperatures")
	public List<TemperatureInfo> getTemperatures(String city, List<Date> dates) {
		System.out.println("myService.getHello():" + myService.getHello());
		List<TemperatureInfo> temperatures = new ArrayList<TemperatureInfo>();
		for (Date date : dates) {
			temperatures.add(new TemperatureInfo(city, date, 5.0, 10.0, 8.0));
		}
		return temperatures;
	}
}
