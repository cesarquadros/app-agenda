package com.ninox.agenda.retrofit;

import com.ninox.agenda.service.SalaService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitSalaConfig {

    private final Retrofit retrofitSala;

    public RetrofitSalaConfig() {
        this.retrofitSala = new Retrofit.Builder()
<<<<<<< HEAD
                .baseUrl("http://104.197.95.182:9091")
=======
                .baseUrl("http://www.mocky.io")
>>>>>>> 2e50d37dd5e30bc719b116011e0e5bbd1ff5d41c
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public SalaService getSalaService(){
        return this.retrofitSala.create(SalaService.class);
    }
}
