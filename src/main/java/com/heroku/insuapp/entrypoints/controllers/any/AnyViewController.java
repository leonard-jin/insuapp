package com.heroku.insuapp.entrypoints.controllers.any;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kh.jin on 2020. 2. 12.
 */
@Controller
public class AnyViewController {

    @GetMapping(path = {"/", "/index"})
    public String viewIndex() {
        return "index";
    }
}
