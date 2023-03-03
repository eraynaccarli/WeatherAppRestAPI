package com.eray.weatherRestfulAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eray.weatherRestfulAPI.models.current.ListData;
import com.eray.weatherRestfulAPI.models.day.ForecastData;
import com.eray.weatherRestfulAPI.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	private final WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	//get current forecast
	@GetMapping("/current/{cityName}")
	public ResponseEntity<ListData> getListData(@PathVariable String cityName){
		return ResponseEntity.ok(weatherService.getForecast(cityName));
	}
	
	// get weekly forecast
	@GetMapping("/weekly/{cityName}/{day}")
	public ResponseEntity<ForecastData> getForecastWeekly(@PathVariable String cityName,@PathVariable int day){
		return ResponseEntity.ok(weatherService.getForecastWeekly(cityName,day));
	}
	
}
