package com.group1.piarealestate.core.utilities.mapper;

import com.group1.piarealestate.business.requests.UserRegisterRequest;
import com.group1.piarealestate.business.responses.UserLoginResponse;
import com.group1.piarealestate.entities.User;
import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();

     UserLoginResponse convertToLoginResponse(User user);
     User convertToUserRegisterRequest(UserRegisterRequest userRegisterRequest) ;


}
