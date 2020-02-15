package com.therich.apps.entrypoints.commons.controllers;

import com.therich.apps.globals.exceptions.BadRequestException;
import org.springframework.validation.BindingResult;

public class BaseRestController {
    protected void checkBindings(BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
    }
}