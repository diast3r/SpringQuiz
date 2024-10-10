package com.quiz.lesson04.domain;

import java.time.LocalDateTime;

public class Seller {
	private int id;
	private String nickname;
	private String profileImageUrl;
	private double temperature;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
}
