package com.therich.apps.globals.validators;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

/**
 * Created by kh.jin on 2020. 2. 25.
 */
class MobileValidatorTest {

    private MobileValidator validator;

    @Test
    public void mobile_정상() {
        //given
        boolean expect = true;
        String id = "010-0000-0000";
        validator = new MobileValidator();

        //when
        boolean act = validator.isValid(id, null);

        //then
        MatcherAssert.assertThat(expect, Is.is(act));
    }

    @Test
    public void mobile_앞자리() {
        //given
        boolean expect = false;
        String id = "012-0000-0000";
        validator = new MobileValidator();

        //when
        boolean act = validator.isValid(id, null);

        //then
        MatcherAssert.assertThat(expect, Is.is(act));
    }

    @Test
    public void mobile_가운데_3자리() {
        //given
        boolean expect = true;
        String id = "010-000-0000";
        validator = new MobileValidator();

        //when
        boolean act = validator.isValid(id, null);

        //then
        MatcherAssert.assertThat(expect, Is.is(act));
    }
}