package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(
			String name, 
			LocalDate date,
			int day, 
			int headcount, 
			String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input: name, phoneNumber
	// output: Booking (List<Booking>를 가공해서 최신 한 개만 반환)
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber); 
		// 예상되는 bookingList
		// [1, 2] 여러 데이터 또는 [1] 한 개의 데이터 -> 마지막 항목(최신)만 반환
		// [] 데이터 없는 경우(null이 아니라 빈 List일 것임) -> null 반환
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}
