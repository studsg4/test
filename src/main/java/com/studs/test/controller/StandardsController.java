package com.studs.test.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.studs.test.dto.QuestionsResponseDTO;
import com.studs.test.dto.StandardsDTO;
import com.studs.test.service.IStandardsService;




@RestController
public class StandardsController 
{
	  private static final String TEST_URL="http://localhost:2222/getStandardAndSubjectAndTopic?";
	  
	   @Autowired
        private RestTemplate restTemplate;


	    @Autowired
	    private IStandardsService service;

	    @PostMapping("/standards/add")
	    public  boolean addStandards(@RequestBody StandardsDTO standardsDTO){
	        return service.addStandards(standardsDTO);
	    }
	 
	    @PutMapping("/standards/update")
	    boolean updateStandards(@RequestBody StandardsDTO standardsDTO) {
	    	return service.updateStandards(standardsDTO);
	    }
	    @GetMapping("/standards/getAll")
	    public ResponseEntity<List<StandardsDTO>> getAllStandards(){
	    	List<StandardsDTO> standards=service.getAllStandards();
            return new ResponseEntity<List<StandardsDTO>>(standards, HttpStatus.OK);
	    }
	    
	    @GetMapping("/standards/getSpecific/{standard}")
	    public ResponseEntity<StandardsDTO>    getSpecificStandards(@PathVariable String standard){
	    StandardsDTO standards=service.getSpecificStandards(standard);
            return new ResponseEntity<StandardsDTO>(standards, HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/standards/delete")
	    public boolean deleteStandardsById(@RequestParam Long id) {
	       return service.deleteStandardsById(id);
	    }
	    
	   @GetMapping("/getTest")
	   public ResponseEntity<List<QuestionsResponseDTO>> findByStandardAndSubjectAndTopic(@RequestParam String standard,@RequestParam String subject, @RequestParam String topic)
	   {
	     ParameterizedTypeReference<List<QuestionsResponseDTO>> typeReference = new ParameterizedTypeReference<List<QuestionsResponseDTO>>()
	     {};
	     ResponseEntity<List<QuestionsResponseDTO>> re = restTemplate.exchange(TEST_URL+"standard="+standard+"&subject="+subject+"&topic="+topic,HttpMethod.GET, null, typeReference);
         List<QuestionsResponseDTO> listQs=re.getBody();    
                                                                                                                                
            return new ResponseEntity<List<QuestionsResponseDTO>>(listQs, HttpStatus.OK);
	    }
	    
	    
	   
	  
	    
	
	
}
