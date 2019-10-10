package com.ninox.agenda.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import com.ninox.agenda.model.Sala;

import java.util.List;

public interface SalaService {

    @GET("/api/ms-sala/salas")
    Call<List<Sala>> buscarSalas(@Header("token") String token);


}
