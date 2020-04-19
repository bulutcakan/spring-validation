package com.bulut.validation.validation;



import com.bulut.validation.validation.annotation.ValidOpsisId;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

;

public class OpsisIdValidator implements ConstraintValidator<ValidOpsisId, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (!StringUtils.isEmpty(s)) {
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
