package com.nttflix.movie.micro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIEDATA")

public class MovieData {
	
	@Id
	private Long id;
	private String name;
	private String status;
	private String mac;
	
	public MovieData() {
		
	}

	public MovieData(Long id, String name, String status, String mac) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.mac = mac;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
}
