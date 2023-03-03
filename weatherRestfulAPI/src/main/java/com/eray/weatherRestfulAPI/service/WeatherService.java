package com.eray.weatherRestfulAPI.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eray.weatherRestfulAPI.models.current.ListData;
import com.eray.weatherRestfulAPI.models.day.ForecastData;

@Service
public class WeatherService {

	private final RestTemplate restTemplate;
	private final String OpenWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?q="; // openweather.com
	private final String HistoryUrl = "http://api.weatherapi.com/v1/forecast.json?key="; // weatherapi.com
	private final String apiKey = "61e421530bbed5ac0b2ed5e3874151ee";
	private final String historyApiKey = "b43420f43f714ad785393243230602 ";
	
	public WeatherService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    public ListData getForecast(String cityName){
	       ListData listData =restTemplate.getForObject(OpenWeatherUrl + cityName + "&appid=" + apiKey, ListData.class);
	       return listData;

	    }
	    public ForecastData getForecastWeekly(String cityName, int day){
	        ForecastData forecastData=restTemplate.getForObject(HistoryUrl+historyApiKey+"&q=" + cityName + "&days=" + day + "&aqi=no&alerts=no", ForecastData.class);
	        return forecastData;
	    }
}
