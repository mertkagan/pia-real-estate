package com.group1.piarealestate.business.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterRequest {

    @NotNull(message = "E-mail alanı boş bırakılamaz.")
    @NotEmpty(message = "E-Mail alanı boş bırakılamaz.")
    private String email;

    @NotNull(message = "Parola alanı boş bırakılamaz.")
    @NotEmpty(message = "Parola alanı boş bırakılamaz.")
    private String password;

    @NotNull(message = "İsim alanı boş bırakılamaz.")
    @NotEmpty(message = "İsim alanı boş bırakılamaz.")
    private String name;

    @NotNull(message = "Soyad alanı boş bırakılamaz.")
    @NotEmpty(message = "Soyad alanı boş bırakılamaz.")
    private String surName;


    @NotNull(message = "Telefon alanı boş bırakılamaz.")
    @NotEmpty(message = "Telefon alanı boş bırakılamaz.")
    private String phoneNumber;
}
