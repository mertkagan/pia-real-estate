package com.group1.piarealestate.business.abstracts;

import com.group1.piarealestate.business.requests.UserLoginRequest;
import com.group1.piarealestate.business.requests.UserRegisterRequest;
import com.group1.piarealestate.business.responses.UserLoginResponse;
import org.springframework.validation.BindingResult;

public interface AuthService {

    String userRegister(UserRegisterRequest userRegisterRequest, BindingResult bindingResult);

    UserLoginResponse userLogin(UserLoginRequest userLoginRequest,BindingResult bindingResult);
}
