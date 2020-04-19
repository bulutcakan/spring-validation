package com.bulut.validation.service.impl;

import com.bulut.validation.marker.OnCreate;
import com.bulut.validation.marker.OnUpdate;
import com.bulut.validation.model.SampleDTO;
import com.bulut.validation.service.SampleService;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
public class SampleServiceImpl implements SampleService {


    @Override
    @Validated(OnCreate.class)
    public SampleDTO createSample(@Valid SampleDTO sampleDTO) {
        return sampleDTO;
    }

    @Override
    @Validated(OnUpdate.class)
    public SampleDTO updateSample(@Valid SampleDTO sampleDTO) {
        return sampleDTO;
    }

    @Override
    public void addNumber(@Range(min = 3, max = 30) Long number) {

    }


}
