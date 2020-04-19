package com.bulut.validation.validation;

import com.migros.common.utils.StringUtils;
import com.migros.common.validation.annotation.ValidOpsisId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

;

public class OpsisIdValidator implements ConstraintValidator<ValidOpsisId, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (!StringUtils.isBlank(s)) {
            try {
                int intValue = Integer.parseInt(s);
                if (intValue >= 0)
                    return true;
                else
                    return false;
            } catch (NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }
}
