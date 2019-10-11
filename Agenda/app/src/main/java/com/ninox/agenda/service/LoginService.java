package com.ninox.agenda.service;

import com.ninox.agenda.model.Token;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface LoginService {

    @GET("/login")
    Call<Token> autenticacao(@Header("user") String user, @Header("pass") String pass);
}
