package com.studs.test.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studs.test.domain.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects,Long> {

	 List<Subjects> findByStandardFk(String standardFk);
	  @Query("SELECT count(*) FROM Subjects WHERE subject= :subject and standardFk= :standardFk")
	 Integer isDataExistOrNot(@Param("subject")String subject, @Param("standardFk")String standardFk);

	 Optional<Subjects> findBySubject(String subject);
	    
	  @Transactional
	  @Modifying
	 Integer deleteBySubject(String subject);
	
}
