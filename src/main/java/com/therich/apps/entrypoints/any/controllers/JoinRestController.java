package com.therich.apps.entrypoints.any.controllers;

import com.therich.apps.entrypoints.any.request.JoinRequest;
import com.therich.apps.entrypoints.commons.controllers.BaseRestController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by kh.jin on 2020. 2. 12.
 * [회원가입]
 */
@RestController
public class JoinRestController extends BaseRestController {

    @PostMapping("/join")
    public @ResponseBody String join(@RequestBody @Valid JoinRequest request, BindingResult result) {
        checkBindings(result);
        return "welcome to insuapp.";
    }
}