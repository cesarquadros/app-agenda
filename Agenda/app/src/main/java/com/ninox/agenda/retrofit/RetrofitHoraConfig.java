package com.ninox.agenda.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitHoraConfig {

    private final Retrofit retrogitHora;

    public RetrofitHoraConfig() {
        this.retrogitHora = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
