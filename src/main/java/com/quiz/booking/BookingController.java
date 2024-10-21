package com.quiz.booking;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;

@Controller
@RequestMapping("/lesson06/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		model.addAttribute("bookingList", bookingBO.getBookingList());
		return "booking/bookingList";
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	@GetMapping("/check-booking-view")
	public String checkBooking() {
		return "booking/checkBooking";
	}
	
	@PostMapping("/deleteBooking")
	@ResponseBody
	public Map<String, Object> deleteBooking(
			@RequestParam("bookingId") int bookingId) {
		Map<String, Object> result = new HashMap<>();
		
		// TODO db delete
		
		// TODO json string 응답
		result.put("code", 200);
		return result;
	}
}
