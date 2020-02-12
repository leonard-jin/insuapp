package com.heroku.insuapp.web.controllers.commons;

import org.springframework.validation.BindingResult;

public interface BaseWebController {
    default void checkBindings(BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException();
        }
    }
}