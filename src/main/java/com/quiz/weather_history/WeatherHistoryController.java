package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherBO;
import com.quiz.weather_history.domain.Weather;

@Controller
@RequestMapping("/weather-history")
public class WeatherHistoryController {
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// db select
		List<Weather> weatherList = weatherBO.getWeather();
		
		// model에 담기
		model.addAttribute("weatherList", weatherList);
		
		return "weather_history/weatherList";
	}
	
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy/MM/dd") LocalDate date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed
			) {
		// db insert
		weatherBO.addWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		
		return "redirect:/weather-history/weather-list-view";
	}
}
