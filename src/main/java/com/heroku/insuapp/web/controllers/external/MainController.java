package com.heroku.insuapp.web.controllers.external;

import com.heroku.insuapp.web.controllers.commons.DefaultExternalController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kh.jin on 2020. 2. 12.
 */
@Controller
public class MainController implements DefaultExternalController {

    @GetMapping("/main")
    public @ResponseBody String pageHome() {
        return "welcome to insuapp.";
    }
}