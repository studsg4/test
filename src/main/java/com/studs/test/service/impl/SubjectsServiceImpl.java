package com.studs.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studs.test.domain.Subjects;
import com.studs.test.dto.SubjectsDTO;
import com.studs.test.repository.SubjectsRepository;
import com.studs.test.service.ISubjectsService;


@Service
public class SubjectsServiceImpl implements ISubjectsService {

	@Autowired
	private SubjectsRepository repo;

	@Override
	public List<SubjectsDTO> getAllSubjects() {
		// TODO Auto-generated method stub
		  List<Subjects> subjectsList = repo.findAll();
	        List<SubjectsDTO> subjectsDTOList = new ArrayList<>();
	       subjectsList.forEach(subjects -> {
	        	SubjectsDTO subjectsDTO = new SubjectsDTO();
	            BeanUtils.copyProperties(subjects, subjectsDTO);
	            subjectsDTOList.add(subjectsDTO);
	        });
	        return subjectsDTOList;
	}

	@Override
	public SubjectsDTO getSpecificSubjects(String subject) {
		// TODO Auto-generated method stub
		 Optional<Subjects> opt = repo.findBySubject(subject);

		 SubjectsDTO subjectsDTO = new SubjectsDTO();
	        if (opt.isPresent()) { 
	        	Subjects subjects = opt.get();
	            BeanUtils.copyProperties(subjects, subjectsDTO);
	            return subjectsDTO;
	        }
	        return subjectsDTO;
	    }


	@Override
	public boolean deleteSubjectsById(Long id) {
		// TODO Auto-generated method stub
	        if (repo.existsById(id)== true) {
	            repo.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	@Override
	public boolean addSubjects(SubjectsDTO subjectsdto) {
		// TODO Auto-generated method stub
		 Subjects subjects = new Subjects();

	        Integer i=repo.isDataExistOrNot(subjectsdto.getSubject(), subjectsdto.getStandardFk());
	        if(i==0){
	            BeanUtils.copyProperties( subjectsdto, subjects);
	            repo.saveAndFlush( subjects);
	            return true;
	        }
	        return false;
	}

	@Override
	public boolean updateSubjects(SubjectsDTO subjectsdto) {
		// TODO Auto-generated method stub
		 Subjects subjects = new Subjects();

	        Integer i=repo.isDataExistOrNot(subjectsdto.getSubject(), subjectsdto.getStandardFk());
	        if(i!=0){
	            BeanUtils.copyProperties( subjectsdto, subjects);
	            repo.saveAndFlush( subjects);
	            return true;
	        }
	        return false;
	}

	@Override
	public List<SubjectsDTO> findByStandardFk(String standardFk) {
		// TODO Auto-generated method stub
		List<Subjects> subjectsList = repo.findByStandardFk(standardFk);
        List<SubjectsDTO> subjectsDTOList = new ArrayList<>();
        subjectsList.forEach(subjects -> {
        	SubjectsDTO subjectsDTO = new SubjectsDTO();
            BeanUtils.copyProperties(subjects, subjectsDTO);
            subjectsDTOList.add(subjectsDTO);
        });
        return subjectsDTOList;
	}
	
}
