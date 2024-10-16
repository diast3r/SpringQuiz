package com.quiz.weather_history.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	public List<WeatherHistory> selectWeatherHistoryList();
	
	public void insertWeatherHistory(
			@Param("date") LocalDate date, 
			@Param("weather") String weather,
			@Param("microDust") String microDust, 
			@Param("temperatures") double temperatures, 
			@Param("precipitation") double precipitation, 
			@Param("windSpeed") double windSpeed);
}
