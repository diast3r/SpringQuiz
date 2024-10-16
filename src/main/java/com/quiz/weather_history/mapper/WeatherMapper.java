package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.weather_history.domain.Weather;

@Mapper
public interface WeatherMapper {
	public List<Weather> selectWeather();
	
	public void insertWeather(Weather weather);
}
