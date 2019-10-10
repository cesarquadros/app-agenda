package com.ninox.agenda.retrofit;

import com.ninox.agenda.service.LoginService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitLoginConfig {

    private final Retrofit retrofitLogin;

    public RetrofitLoginConfig() {
        this.retrofitLogin = new Retrofit.Builder()
                .baseUrl("http://104.197.95.182:9091")
                //.baseUrl("http://www.mocky.io/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public LoginService autenticar(){return this.retrofitLogin.create(LoginService.class);}
}
