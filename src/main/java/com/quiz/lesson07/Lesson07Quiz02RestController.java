package com.quiz.lesson07;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public RecruitEntity quiz02_1() {
		// id: 8
		return recruitRepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> quiz02_2(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> quiz02_3() {
		// 웹 back-end 개발자이면서 정규직인 공고 조회
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> quiz02_4() {
		// 정규직이거나 연봉이 9000 이상인 공고
		// (Type)And(SalaryGreaterThanEqual)
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> quiz02_5() {
		// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> quiz02_6() {
		// 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	public List<RecruitEntity> quiz02_7() {
		return recruitRepository.findCondition("2024-4-10", 8100, "정규직");
	}
}
