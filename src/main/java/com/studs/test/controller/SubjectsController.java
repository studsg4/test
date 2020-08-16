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

import com.studs.test.dto.SubjectsDTO;
import com.studs.test.service.ISubjectsService;


@RestController
public class SubjectsController {

	    @Autowired
	    private ISubjectsService service;

	    @PostMapping("/subjects/add")
	    public  boolean addSubjects(@RequestBody SubjectsDTO subjectsDTO){
	        return service.addSubjects(subjectsDTO);
	    }
	   
	    @PutMapping("/subjects/update")
	    boolean updateStage1(@RequestBody SubjectsDTO subjectsDTO) {
	    	return service.updateSubjects(subjectsDTO);
	    }
	    @GetMapping("/subjects/getAll")
	    public ResponseEntity<List<SubjectsDTO>> getAllSubjects(){
	    	List<SubjectsDTO> subjects=service.getAllSubjects();
            return new ResponseEntity<List<SubjectsDTO>>(subjects, HttpStatus.OK);
	    }
	    
	    @GetMapping("/subjects/getSpecific/{subject}")
	    public ResponseEntity<SubjectsDTO> getSpecificStage2(@PathVariable String subject){
	    SubjectsDTO subjects=service.getSpecificSubjects(subject);
            return new ResponseEntity<SubjectsDTO>(subjects, HttpStatus.OK);
	    }
	    
	
	    @DeleteMapping("/subjects/delete")
	    public boolean deleteSubjectsById(@RequestParam Long id) {
	       return service.deleteSubjectsById(id);
	    }
	    
	    @GetMapping("/subjects/getsubject/{standardFk}")
	    public ResponseEntity<List<SubjectsDTO>> findByStandardFk(@PathVariable String standardFk){
	    	List<SubjectsDTO> subjects=service.findByStandardFk(standardFk);
            return new ResponseEntity<List<SubjectsDTO>>(subjects, HttpStatus.OK);
	    }
	    
	
	
}
