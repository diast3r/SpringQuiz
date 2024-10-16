package com.quiz.weather_history;

import java.io.IOException;
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

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@Controller
@RequestMapping("/weather-history")
public class WeatherHistoryController {
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// db select
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model에 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/weatherList";
	}
	
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd") LocalDate date,
			// db에 String으로 날짜를 보내도 date형식으로 추가되므로 String형태로 RequestParam을 받아도 된다.
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed
			// HttpServletResponse response // 서블릿을 통한 리다이렉트를 하려면 사용할 파라미터.
			) {
		// db insert
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		// 목록 화면으로 이동
		// Spring은 servlet 기반이므로 HttpServlet을 사용해서 redirect하는 것도 가능.
//		response.sendRedirect("/weather-history/weather-list-view");
		return "redirect:/weather-history/weather-list-view";
	}
}
