package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "recruit")
public class RecruitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "companyId")
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	@Temporal(TemporalType.DATE)
	private LocalDate deadline;
	
	@CreationTimestamp
	@Column(name = "createdAt", updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
