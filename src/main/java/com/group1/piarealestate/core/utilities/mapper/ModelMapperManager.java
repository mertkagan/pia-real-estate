package com.group1.piarealestate.core.utilities.mapper;

import com.group1.piarealestate.business.requests.UserRegisterRequest;
import com.group1.piarealestate.business.responses.UserLoginResponse;
import com.group1.piarealestate.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{


    private ModelMapper modelMapper;


    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)//belirsizlik olduğunda onu ignore et.
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        //GEVŞEK MAPLAMA : responseda sadece olanı mapla

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        //herşeyi mapla

        return this.modelMapper;
    }

    @Override
    public UserLoginResponse convertToLoginResponse(User user) {
        return modelMapper.map(user, UserLoginResponse.class);
    }

    @Override
    public User convertToUserRegisterRequest(UserRegisterRequest userRegisterRequest) {
        return null;
    }
}
