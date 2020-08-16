package com.studs.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDS_subjects")
public class Subjects 
{
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long t2Id ;
	private String subject;
	private String standardFk;
	private String author;

	public Long getT2Id() {
		return t2Id;
	}

	public void setT2Id(Long t2Id) {
		this.t2Id = t2Id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStandardFk() {
		return standardFk;
	}

	public void setStandardFk(String standardFk) {
		this.standardFk = standardFk;
	}
	
	
	
}
