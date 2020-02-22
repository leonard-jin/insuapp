package com.therich.apps.entrypoints.any.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kh.jin on 2020. 2. 12.
 */
@Controller
public class AnyViewController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path = {"/", "/main"})
    public String pageMain() {
        log.debug(">>> page main.");
        return "main";
    }

    @GetMapping(path = "/login")
    public String pageLogin() {
        log.debug(">>> page login.");
        return "any/login";
    }

    @GetMapping(path = "/join")
    public String pageJoin() {
        log.debug(">>> page join.");
        return "any/join";
    }
}