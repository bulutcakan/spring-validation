package com.bulut.validation.controller;

import com.bulut.validation.model.SampleDTO;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/test")
@Validated
public class ValidationTestController {

    @PostMapping("/model")
    public ResponseEntity testDTOValidation(@RequestBody SampleDTO sampleDTO) {
        return null;

    }

    @PostMapping("/{name}")
    public ResponseEntity testParameterValidation(@PathVariable @NotBlank String name,@RequestParam @Positive Long age,@RequestParam
                                            @Range(min = 99, max = Long.MAX_VALUE,
                                                    message = "Cok bu rakam cok") Long number) {
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }
}
