package com.ninox.agenda.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import com.ninox.agenda.model.Sala;

import java.util.List;

public interface SalaService {

<<<<<<< HEAD
    @GET("/api/ms-sala/salas")
    Call<List<Sala>> buscarSalas(@Header("token") String token);
=======
    @GET("/v2/5d9d3c19310000640050e18d")
    Call<List<Sala>> buscarSalas();
>>>>>>> 2e50d37dd5e30bc719b116011e0e5bbd1ff5d41c

}
