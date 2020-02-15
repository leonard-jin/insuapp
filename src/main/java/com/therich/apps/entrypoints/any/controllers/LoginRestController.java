package com.therich.apps.entrypoints.any.controllers;

import com.therich.apps.entrypoints.commons.controllers.BaseRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kh.jin on 2020. 2. 12.
 */
@RestController
public class LoginRestController extends BaseRestController {

    @PostMapping("/login")
    public @ResponseBody String pageHome() {
        return "welcome to insuapp.";
    }
}