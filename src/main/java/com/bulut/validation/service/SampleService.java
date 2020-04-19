package com.bulut.validation.service;

import com.bulut.validation.model.SampleDTO;
import org.hibernate.validator.constraints.Range;

public interface SampleService {

    SampleDTO createSample(SampleDTO sampleDTO);

    SampleDTO updateSample(SampleDTO sampleDTO);

    void addNumber(@Range(min = 3, max = 30) Long number);

}
