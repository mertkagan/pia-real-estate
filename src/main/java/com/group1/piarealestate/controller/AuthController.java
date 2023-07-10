package com.group1.piarealestate.controller;

import com.group1.piarealestate.business.abstracts.AuthService;
import com.group1.piarealestate.business.requests.UserLoginRequest;
import com.group1.piarealestate.business.requests.UserRegisterRequest;
import com.group1.piarealestate.business.responses.UserLoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;



    @PostMapping()
    public String userRegister(@Valid @RequestBody UserRegisterRequest createUsersRequest, BindingResult bindingResult){
        return authService.userRegister(createUsersRequest,bindingResult);


    }

    @GetMapping
    public UserLoginResponse userLogin(@Valid @RequestBody UserLoginRequest userLoginRequest,BindingResult bindingResult){
        return authService.userLogin(userLoginRequest,bindingResult);
    }

}
