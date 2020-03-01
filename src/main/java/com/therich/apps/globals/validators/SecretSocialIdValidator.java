package com.therich.apps.globals.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Created by kh.jin on 2020. 2. 22.
 */
@Component
public class SecretSocialIdValidator implements ConstraintValidator<SecretSocialId, String> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final static String DELIMITER_STR = "-";
    private final static String REG_EXP = "^[0-9]+$";

    @Override
    public void initialize(SecretSocialId constraintAnnotation) {
        log.debug(">>> initialize validators");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.contains(DELIMITER_STR)) {
            return false;
        }

        String[] arr = s.split(DELIMITER_STR);
        if (arr.length > 2) {
            return false;
        }

        if (!valid(arr[0], 6)) {
            return false;
        }

        if (!valid(arr[1], 7)) {
            return false;
        }

        return true;
    }

    private boolean valid(String src, int len) {
        if (src.length() != len) {
            return false;
        }

        if (!src.matches(REG_EXP)) {
            return false;
        }

        return true;
    }
}
