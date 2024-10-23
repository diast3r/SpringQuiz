package com.quiz.lesson07.bo;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

import jakarta.persistence.Column;

@Service
public class CompanyBO {
	@Autowired
	private CompanyRepository companyRepository;
	
	// jpa
	public CompanyEntity addCompany(
			String name,
			String business,
			String scale,
			int headcount) {
				
		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build()
				);
	}
}
