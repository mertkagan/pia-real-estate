package com.group1.piarealestate.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {

    private String message;

    private String id;

    private String name;

    private String surName;

    private String email;

    private String phoneNumber;
}
