package com.bulut.validation.service;

import com.bulut.validation.marker.OnCreate;
import com.bulut.validation.model.SampleDTO;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
@Validated
public interface SampleService {

    SampleDTO createSample(@Valid  SampleDTO sampleDTO);

    SampleDTO updateSample(@Valid SampleDTO sampleDTO);

    void addNumber(@Range(min = 3, max = 30) Long number);

}
