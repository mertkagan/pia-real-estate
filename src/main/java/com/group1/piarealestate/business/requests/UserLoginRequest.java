package com.group1.piarealestate.business.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginRequest {

    @NotNull(message = "E-mail alanı boş bırakılamaz.")
    @NotEmpty(message = "E-Mail alanı boş bırakılamaz.")
    private String email;


    @NotNull(message = "Password alanı boş bırakılamaz.")
    @NotEmpty(message = "Password alanı boş bırakılamaz.")
    private String password;
}
