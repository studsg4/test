package com.studs.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studs.test.domain.Topics;
import com.studs.test.dto.TopicsDTO;
import com.studs.test.repository.TopicsRepository;
import com.studs.test.service.ITopicsService;

@Service
public class TopicsServiceImpl implements ITopicsService {

	@Autowired
	private TopicsRepository repo;

	@Override
	public List<TopicsDTO> getAllTopics() {
		// TODO Auto-generated method stub
		  List<Topics> topicsList = repo.findAll();
	        List<TopicsDTO> topicsDTOList = new ArrayList<>();
	        topicsList.forEach(topics -> {
	        	TopicsDTO topicsDTO = new TopicsDTO();
	            BeanUtils.copyProperties(topics, topicsDTO);
	            topicsDTOList.add(topicsDTO);
	        });
	        return topicsDTOList;
	}

	@Override
	public TopicsDTO getSpecificTopics(String topic) {
		// TODO Auto-generated method stub
		 Optional<Topics> opt = repo.findByTopic(topic);

		 TopicsDTO topicsDTO = new TopicsDTO();
	        if (opt.isPresent()) { 
	        	Topics topics = opt.get();
	            BeanUtils.copyProperties(topics, topicsDTO);
	            return topicsDTO;
	        }
	        return topicsDTO;
	    }


	@Override
	public boolean deleteTopicsById(Long id) {
		// TODO Auto-generated method stub
	        if (repo.existsById(id)== true) {
	            repo.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	@Override
	public boolean addTopics(TopicsDTO topicsdto) {
		// TODO Auto-generated method stub
		 Topics topics = new Topics();

	        Integer i=repo.isDataExistOrNot(topicsdto.getTopic(), topicsdto.getSubjectFk());
	        if(i==0){
	            BeanUtils.copyProperties( topicsdto, topics);
	            repo.saveAndFlush( topics);
	            return true;
	        }
	        return false;
	}

	@Override
	public boolean updateTopics(TopicsDTO topicsdto) {
		// TODO Auto-generated method stub
		 Topics topics = new Topics();

	        Integer i=repo.isDataExistOrNot(topicsdto.getTopic(), topicsdto.getSubjectFk());
	        if(i!=0){
	            BeanUtils.copyProperties( topicsdto, topics);
	            repo.saveAndFlush( topics);
	            return true;
	        }
	        return false;
	}

	@Override
	public List<TopicsDTO> findBySubjectFk(String subjectFk) {
		// TODO Auto-generated method stub
		 List<Topics> topicsList = repo.findBySubjectFk(subjectFk);
	        List<TopicsDTO> topicsDTOList = new ArrayList<>();
	        topicsList.forEach(topics -> {
	        	TopicsDTO topicsDTO = new TopicsDTO();
	            BeanUtils.copyProperties(topics, topicsDTO);
	            topicsDTOList.add(topicsDTO);
	        });
	        return topicsDTOList;
	}

		
	
	
}
