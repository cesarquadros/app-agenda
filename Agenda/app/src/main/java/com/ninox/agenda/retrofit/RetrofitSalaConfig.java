package com.ninox.agenda.retrofit;

import com.ninox.agenda.service.SalaService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitSalaConfig {

    private final Retrofit retrofitSala;

    public RetrofitSalaConfig() {
        this.retrofitSala = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8083")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public SalaService getSalaService(){
        return this.retrofitSala.create(SalaService.class);
    }
}
