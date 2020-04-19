package com.bulut.validation.controller;

import com.bulut.validation.model.SampleDTO;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/test")
@Validated
public class ValidationTestController {

    @PostMapping("/model")
    public ResponseEntity testDTOValidation(@Valid @RequestBody SampleDTO sampleDTO) {
        return null;

    }

    @PostMapping("/binding/model")
    public ResponseEntity testDTOValidation( @RequestBody @Valid SampleDTO sampleDTO, BindingResult bindingResult, HttpServletResponse response) {
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

    /*
    Bu controller da herhan gibi constraint hatası aldıgında bu ExceptionHandler duser

    @ExceptionHandler
    public void handle(ConstraintViolationException constraintViolationException, HttpServletResponse response) {
        response.setStatus(HttpStatus.PRECONDITION_FAILED.value());
    }

     */
}

