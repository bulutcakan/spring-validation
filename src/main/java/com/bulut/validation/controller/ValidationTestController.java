package com.bulut.validation.controller;

import com.bulut.validation.model.SampleDTO;
import com.bulut.validation.service.SampleService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/test")
@Validated
public class ValidationTestController {

    @Autowired
    SampleService sampleService;

    @PostMapping("/model")
    public ResponseEntity testDTOValidation(@Valid @RequestBody SampleDTO sampleDTO) {
        return null;

    }

    @PutMapping("/model")
    public ResponseEntity update( @RequestBody SampleDTO sampleDTO) {
        return new ResponseEntity<SampleDTO>(sampleService.updateSample(sampleDTO), HttpStatus.ACCEPTED);

    }

    @PostMapping("/model/save")
    public ResponseEntity create( @RequestBody @Valid SampleDTO sampleDTO) {
        return new ResponseEntity<SampleDTO>(sampleService.createSample(sampleDTO), HttpStatus.ACCEPTED);

    }

    @PostMapping("/binding/model")
    public ResponseEntity testDTOValidation(@RequestBody @Valid SampleDTO sampleDTO, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<SampleDTO>(sampleDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{name}")
    public ResponseEntity testParameterValidation(@PathVariable @NotBlank String name, @RequestParam @Positive Long age, @RequestParam
    @Range(min = 99, max = Long.MAX_VALUE,
            message = "Cok bu rakam cok") Long number) {
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }


}

