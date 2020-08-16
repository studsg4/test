package com.studs.test.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studs.test.domain.Topics;

public interface TopicsRepository extends JpaRepository<Topics, Long> {
	List<Topics> findBySubjectFk(String subjectFk);
	
	
	
    @Query("SELECT count(*) FROM Topics WHERE topic= :topic and subjectFk= :subjectFk")
    Integer isDataExistOrNot(@Param("topic")String topic, @Param("subjectFk")String subjectFk);

    Optional<Topics> findByTopic(String topic);
    @Transactional
    @Modifying
    Integer deleteByTopic(String topic);

}
