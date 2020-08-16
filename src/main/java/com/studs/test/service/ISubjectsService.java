package com.studs.test.service;

import java.util.List;

import com.studs.test.dto.SubjectsDTO;


public interface ISubjectsService {
    List<SubjectsDTO> getAllSubjects();
    SubjectsDTO getSpecificSubjects(String subject);
    boolean deleteSubjectsById(Long id);

    boolean addSubjects(SubjectsDTO subjectsDTO);
    boolean updateSubjects(SubjectsDTO subjectsDTO);
    
    List<SubjectsDTO> findByStandardFk(String standardFk);
}
  