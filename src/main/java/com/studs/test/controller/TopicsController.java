package com.studs.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.studs.test.dto.TopicsDTO;

import com.studs.test.service.ITopicsService;


@RestController
public class TopicsController {

	    @Autowired
	    private ITopicsService service;

	    @PostMapping("/topics/add")
	    public  boolean add(@RequestBody TopicsDTO topicsDTO){
	        return service.addTopics(topicsDTO);
	    }
	   
	    @PutMapping("/topics/update")
	    boolean updateStandards(@RequestBody TopicsDTO topicsDTO) {
	    	return service.updateTopics(topicsDTO);
	    }
	    @GetMapping("/topics/getAll")
	    public ResponseEntity<List<TopicsDTO>> getAllTopics(){
	    	List<TopicsDTO> topics=service.getAllTopics();
            return new ResponseEntity<List<TopicsDTO>>(topics, HttpStatus.OK);
	    }
	    
	    @GetMapping("/topics/getSpecific/{subType}")
	    public ResponseEntity<TopicsDTO> getSpecificTopics(@PathVariable String subject){
	    TopicsDTO topics=service.getSpecificTopics(subject);
            return new ResponseEntity<TopicsDTO>(topics, HttpStatus.OK);
	    }
	    
	
	    @DeleteMapping("/topics/delete")
	    public boolean deleteTopicsById(@RequestParam Long id) {
	       return service.deleteTopicsById(id);
	    }
	    
	    @GetMapping("/topics/getSubject/{subjectFk}")
	    public ResponseEntity<List<TopicsDTO>> findBySubjectFk(@PathVariable String subjectFk){
	    	List<TopicsDTO> topics=service.findBySubjectFk(subjectFk);
            return new ResponseEntity<List<TopicsDTO>>(topics, HttpStatus.OK);
	    }
	    
	
	
}
