package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

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
	
	// jpa update
	public CompanyEntity updateCompanyScaleHeadCountById(int id, String scale, int headcount) {
		// 기존 데이터 조회
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// 업데이트 진행
		if (company != null) {
			company = companyRepository.save(company.toBuilder()
				.scale(scale)
				.headcount(headcount)
				.build());
		}
		
		// company가 null(id로 찾은 데이터가 없을 때)
		return company;
	}
	
	// delete(JPA)
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
		
	}
	
	
}
