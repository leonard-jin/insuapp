package com.therich.apps.entrypoints.controllers.any;

import com.therich.apps.entrypoints.controllers.BaseRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kh.jin on 2020. 2. 12.
 */
@RestController
public class MainRestController implements BaseRestController {

    @GetMapping("/main")
    public @ResponseBody String pageHome() {
        return "welcome to insuapp.";
    }
}