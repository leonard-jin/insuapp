package com.therich.apps.globals.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by kh.jin on 2020. 2. 24.
 */
@Component
public class MobileValidator implements ConstraintValidator<Mobile, String> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final static String DELIMITER_STR = "-";
    private final static String REG_EXP = "^[0-9]+$";

    private final static String[] PREFIX = {"010", "011", "016", "017", "018", "019"};

    @Override
    public void initialize(Mobile constraintAnnotation) {
        log.debug(">>> Initialize mobile validator.");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.contains(DELIMITER_STR)) {
            return false;
        }

        String[] arr = s.split(DELIMITER_STR);
        if (Arrays.stream(arr)
                .filter(a -> !a.matches(REG_EXP))
                .findFirst()
                .isPresent()) {
            return false;
        }

        if (!Arrays.stream(PREFIX)
                .filter(p -> p.equalsIgnoreCase(arr[0]))
                .findFirst()
                .isPresent()) {
            return false;
        }

        if ((arr[1].length() != 3 && arr[1].length() != 4)) {
            return false;
        }

        if (arr[2].length() != 4) {
            return false;
        }

        return true;
    }
}
