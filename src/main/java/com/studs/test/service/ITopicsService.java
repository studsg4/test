package com.studs.test.service;

import java.util.List;

import com.studs.test.dto.TopicsDTO;


public interface ITopicsService {
    List<TopicsDTO> getAllTopics();
    TopicsDTO getSpecificTopics(String topic);
    boolean deleteTopicsById(Long id);

    boolean addTopics(TopicsDTO topicsDTO);
    boolean updateTopics(TopicsDTO topicsDTO);
    
	List<TopicsDTO> findBySubjectFk(String subjectFk);
}
