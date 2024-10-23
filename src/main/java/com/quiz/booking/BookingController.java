package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/lesson06/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	// delete booking - AJAX 요청
	// DeleteMapping
	@DeleteMapping("/delete-booking")
	@ResponseBody
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookingBO.deleteBookingById(id); 
		
		// json string 응답
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 204);
			result.put("result", "성공");
		} else {
			result.put("code", 512);
			result.put("error_message", "삭제할 대상이 없습니다.");
		}
		return result;
	}
	
	
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);
		// {"code":200, "result":booking}
		// => {"code":200, "result":{"id":3, "name":"양준호", ...}
		
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 200);
			result.put("result", booking);
		} else {
			result.put("code", 500);
			result.put("error_message", "조회 결과가 없습니다.");
		}
		
		return result;
	}
	
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// 예약하기 insert - AJAX 요청
	@PostMapping("/make-booking")
	@ResponseBody
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date, // yyyy-MM-dd의 형태이면 자동으로 형변환해줄 수 있음.
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답 json
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
}
