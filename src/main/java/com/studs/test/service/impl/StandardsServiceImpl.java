package com.studs.test.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studs.test.domain.Standards;
import com.studs.test.dto.StandardsDTO;
import com.studs.test.repository.StandardsRepository;
import com.studs.test.service.IStandardsService;

@Service
public class StandardsServiceImpl implements IStandardsService {

	@Autowired
	private StandardsRepository repo;

	@Override
	public List<StandardsDTO> getAllStandards() {
		// TODO Auto-generated method stub
		  List<Standards> standardsList = repo.findAll();
	        List<StandardsDTO> standardsDTOList = new ArrayList<>();
	        standardsList.forEach(standards -> {
	        	StandardsDTO standardsDTO = new StandardsDTO();
	            BeanUtils.copyProperties(standards, standardsDTO);
	            standardsDTOList.add(standardsDTO);
	        });
	        return standardsDTOList;
	}

	@Override
	public StandardsDTO getSpecificStandards(String standard) {
		// TODO Auto-generated method stub
		 Optional<Standards> opt = repo.findByStandard(standard);

		 StandardsDTO standardsDTO = new StandardsDTO();
	        if (opt.isPresent()) { 
	        	Standards standards = opt.get();
	            BeanUtils.copyProperties(standards, standardsDTO);
	            return standardsDTO;
	        }
	        return standardsDTO;
	    }


	@Override
	public boolean deleteStandardsById(Long id) {
		// TODO Auto-generated method stub
	        if (repo.existsById(id)== true) {
	            repo.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	@Override
	public boolean addStandards(StandardsDTO standardsdto) {
		// TODO Auto-generated method stub
		 Standards standards = new Standards();

	        Integer i=repo.isDataExistOrNot(standardsdto.getStandard());
	        if(i==0){
	            BeanUtils.copyProperties( standardsdto, standards);
	            repo.saveAndFlush( standards);
	            return true;
	        }
	        return false;
	}

	@Override
	public boolean updateStandards(StandardsDTO standardsdto) {
		// TODO Auto-generated method stub
		 Standards standards = new Standards();

	        Integer i=repo.isDataExistOrNot(standardsdto.getStandard());
	        if(i!=0)
	        {
	            BeanUtils.copyProperties( standardsdto, standards);
	            repo.saveAndFlush( standards);
	            return true;
	        }
	        return false;
	}
	
	
	
}
