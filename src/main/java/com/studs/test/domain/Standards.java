package com.studs.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDS_Standards")
public class Standards {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long t1Id ;
    
	
	private String standard;
	private String author;
	public Long getT1Id() {
		return t1Id;
	}
	public void setT1Id(Long t1Id) {
		this.t1Id = t1Id;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
