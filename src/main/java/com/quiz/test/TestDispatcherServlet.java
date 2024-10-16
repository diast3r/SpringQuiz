package com.quiz.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestDispatcherServlet {
	@RequestMapping("/")
	@ResponseBody
	public String dispatcher() {
		return "성공?";
	}
}
