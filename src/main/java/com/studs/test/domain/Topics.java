package com.studs.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDS_topics")
public class Topics {
	
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long t3Id ;
	private String topic;
	private String subjectFk;
	
	private String author;

	public Long getT3Id() {
		return t3Id;
	}

	public void setT3Id(Long t3Id) {
		this.t3Id = t3Id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSubjectFk() {
		return subjectFk;
	}

	public void setSubjectFk(String subjectFk) {
		this.subjectFk = subjectFk;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
}
