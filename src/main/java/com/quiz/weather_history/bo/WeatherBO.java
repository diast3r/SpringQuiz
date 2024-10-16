package com.quiz.weather_history.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.Weather;
import com.quiz.weather_history.mapper.WeatherMapper;

@Service
public class WeatherBO {
	@Autowired
	private WeatherMapper weatherMapper;
	
	public List<Weather> getWeather() {
		return weatherMapper.selectWeather();
	}
	
	public void addWeather(
			LocalDate date,
			String weather,
			String microDust,
			double temperatures,
			double precipitation,
			double windSpeed
			) {
		Weather weatherDTO = new Weather();
		weatherDTO.setDate(date);
		weatherDTO.setWeather(weather);
		weatherDTO.setMicroDust(microDust);
		weatherDTO.setTemperatures(temperatures);
		weatherDTO.setPrecipitation(precipitation);
		weatherDTO.setWindSpeed(windSpeed);
		
		weatherMapper.insertWeather(weatherDTO);
	};
}
