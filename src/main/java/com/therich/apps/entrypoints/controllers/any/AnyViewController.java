package com.therich.apps.entrypoints.controllers.any;

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

    @GetMapping(path = {"/", "/index"})
    public String index() {
        log.debug(">>> page main.");
        return "index";
    }

    @GetMapping(path = "/pages/signin")
    public String signin() {
        log.debug(">>> page signin.");
        return "/any/signin";
    }

    @GetMapping(path = "/pages/signup")
    public String singup() {
        log.debug(">>> page signup.");
        return "/any/signup";
    }
}