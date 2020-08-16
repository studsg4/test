package com.studs.test.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studs.test.domain.Standards;



public interface StandardsRepository extends JpaRepository<Standards,Long> {

    @Query("SELECT count(*) FROM Standards WHERE standard= :standard")
    Integer isDataExistOrNot(@Param("standard")String standard);

    Optional<Standards> findByStandard(String standard);
    
    @Transactional
    @Modifying
    Integer deleteByStandard(String standard);
	
	
}
