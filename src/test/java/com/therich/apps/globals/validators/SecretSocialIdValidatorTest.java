package com.therich.apps.globals.validators;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kh.jin on 2020. 2. 23.
 */
class SecretSocialIdValidatorTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private SecretSocialIdValidator validator;

    @Before
    public void setup() {
        log.debug("before?");
    }

    @Test
    void isValid() {
        //given
        boolean expect = true;
        String id = "830110-1109110";
        validator = new SecretSocialIdValidator();

        if (validator == null) {
            System.out.println("null?");
        }

        //when
        boolean act = validator.isValid(id, null);

        //then
        MatcherAssert.assertThat(expect, Is.is(act));
    }

    @Test
    void isValid_하이픈_없는_경우() {
        //given
        boolean expect = false;
        String id = "8301101109110";
        validator = new SecretSocialIdValidator();

        if (validator == null) {
            System.out.println("null?");
        }

        //when
        boolean act = validator.isValid(id, null);

        //then
        MatcherAssert.assertThat(expect, Is.is(act));
    }

    @Test
    void isValid_문자포함된_경우() {
        //given
        boolean expect = false;
        String id = "830110-r1109110";
        validator = new SecretSocialIdValidator();

        if (validator == null) {
            System.out.println("null?");
        }

        //when
        boolean act = validator.isValid(id, null);
        log.debug(">>> result : {}", act);

        //then
        MatcherAssert.assertThat(expect, Is.is(act));
    }
}