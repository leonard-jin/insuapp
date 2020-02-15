package com.therich.apps.entrypoints.controllers;

import org.springframework.validation.BindingResult;

public interface BaseRestController {
    default void checkBindings(BindingResult result) {
        if (result.hasErrors()) throw new RuntimeException();
    }
}