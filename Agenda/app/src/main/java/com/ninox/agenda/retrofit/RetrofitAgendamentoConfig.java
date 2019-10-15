package com.ninox.agenda.retrofit;

import com.ninox.agenda.service.AgendamentoService;
import com.ninox.agenda.service.HorarioService;
import com.ninox.agenda.service.LoginService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitAgendamentoConfig {

    private final Retrofit retrofitAgendamento;

    public RetrofitAgendamentoConfig() {
        this.retrofitAgendamento = new Retrofit.Builder()
                .baseUrl("http://104.197.95.182:9091")
                //.baseUrl("http://www.mocky.io/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public AgendamentoService agendamento(){
        return this.retrofitAgendamento.create(AgendamentoService.class);
    }
}


