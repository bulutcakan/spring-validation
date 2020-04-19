package com.bulut.validation.service.impl;

import com.bulut.validation.model.SampleDTO;
import com.bulut.validation.service.SampleService;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class SampleServiceImpl implements SampleService {

    @Override
    public SampleDTO createSample(SampleDTO sampleDTO) {
        return null;
    }

    @Override
    public SampleDTO updateSample(SampleDTO sampleDTO) {
        return null;
    }

    @Override
    public void addNumber(@Range(min = 3, max = 30) Long number) {

    }
}
