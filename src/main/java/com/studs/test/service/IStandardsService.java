package com.studs.test.service;

import java.util.List;

import com.studs.test.dto.StandardsDTO;


public interface IStandardsService {
    List<StandardsDTO> getAllStandards();
    StandardsDTO getSpecificStandards(String standard);
    boolean deleteStandardsById(Long id);

    boolean addStandards(StandardsDTO standardsDTO);
    boolean updateStandards(StandardsDTO standardsDTO);
}
