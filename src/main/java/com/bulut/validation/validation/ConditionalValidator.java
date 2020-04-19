package com.bulut.validation.validation;


import com.bulut.validation.validation.annotation.Conditional;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

public class ConditionalValidator implements ConstraintValidator<Conditional, Object> {

    private String selected;
    private String[] required;
    private String message;


    private final Logger log = LoggerFactory.getLogger(ConditionalValidator.class);

    @Override
    public void initialize(Conditional requiredIfChecked) {
        selected = requiredIfChecked.selected();
        required = requiredIfChecked.required();
        message = requiredIfChecked.message();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        Boolean valid = true;
        try {
            Object checkedValue = BeanUtils.getProperty(object, selected);

            if (!isEmptyObject(checkedValue)) {

                for (String propName : required) {

                    Object requiredValue = BeanUtils.getProperty(object, propName);
                    valid = requiredValue != null && !isEmptyObject(requiredValue);
                    log.debug("Integration required value: :  {}", requiredValue);
                    if (!valid) {

                        String msgDefault = context.getDefaultConstraintMessageTemplate() + " Required field is " + propName;
                        context.disableDefaultConstraintViolation();
                        context.buildConstraintViolationWithTemplate(msgDefault).addPropertyNode(propName).addConstraintViolation();
                        return false;
                    }
                }
            }
            if (checkedValue != null && checkedValue.equals(""))
                return false;
        } catch (IllegalAccessException e) {
            log.error("Accessor method is not available for class : {}, exception : {}", object.getClass().getName(), e);
            return false;
        } catch (NoSuchMethodException e) {
            log.error("Field or method is not present on class : {}, exception : {}", object.getClass().getName(), e);
            return false;
        } catch (InvocationTargetException e) {
            log.error("An exception occurred while accessing class : {}, exception : {}", object.getClass().getName(), e);
            return false;
        }
        return valid;
    }

    public static boolean isEmptyObject(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String) {
            return StringUtils.isEmpty(((String) object).trim());
        } else if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        } else if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        } else if (object instanceof Collection) {
            return ((Collection) object).isEmpty();
        } else {
            return object instanceof Map ? ((Map) object).isEmpty() : false;
        }
    }
}
