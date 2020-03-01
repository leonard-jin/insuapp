package com.therich.apps.entrypoints.controllers;

import com.therich.apps.globals.exceptions.BadRequestException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class BaseRestController {
    protected void checkBindings(BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
    }
}