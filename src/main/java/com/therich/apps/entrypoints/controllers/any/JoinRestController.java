package com.therich.apps.entrypoints.controllers.any;

import com.therich.apps.entrypoints.controllers.BaseRestController;
import com.therich.apps.usecase.members.MemberRegisterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by kh.jin on 2020. 2. 12.
 * [회원가입]
 */
@RestController
public class JoinRestController extends BaseRestController {

    private final MemberRegisterUseCase service;


    @Autowired
    public JoinRestController(MemberRegisterUseCase service) {
        this.service = service;
    }

    @PostMapping(value = "/join")
    public String join(@RequestBody @Valid MemberRegisterUseCase.Command command, BindingResult result) {
        checkBindings(result);
        service.join(command);
        return "welcome to insuapp.";
    }
}