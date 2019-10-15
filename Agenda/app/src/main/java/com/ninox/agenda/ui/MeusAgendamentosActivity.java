package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Agendamento;
import com.ninox.agenda.retrofit.RetrofitAgendamentoConfig;
import com.ninox.agenda.ui.recycle.RecycleAgendamentosAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeusAgendamentosActivity extends AppCompatActivity {

    private Button btnNovoAgendamento;
    private Context context;
    private List<Agendamento> agendamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agendamentos);

        initializeComponents();
        this.btnNovoAgendamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDate = new Intent(MeusAgendamentosActivity.this, DataAgendaActivity.class);
                startActivity(goDate);
            }
        });
    }

    public void initializeComponents(){
        this.btnNovoAgendamento = findViewById(R.id.btn_novo_agendamento);
        agendamentos = new ArrayList<>();
        this.context = this;
    }

    public void initializeRecycle(){
        RecyclerView rv = findViewById(R.id.recycle_view_agendamentos);

        for(int i = 0; i < agendamentos.size(); i++){
            try {
                SimpleDateFormat simpleDateFormatView = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat simpleDateFormatReq = new SimpleDateFormat("yyyy-MM-dd");

                Date date = simpleDateFormatReq.parse(agendamentos.get(i).getDataAgendamento());

                String dateStrReq = simpleDateFormatView.format(date);

                agendamentos.get(i).setDataAgendamento(dateStrReq);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        RecycleAgendamentosAdapter recycleAgendamentosAdapter = new RecycleAgendamentosAdapter(agendamentos, context);
        rv.setAdapter(recycleAgendamentosAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);
    }

    public void requisicaoAgendamentos(){
        Call<List<Agendamento>> retAgend = new RetrofitAgendamentoConfig().agendamento().getAgendamentosByCliente(MainActivity.TOKEN, MainActivity.CLIENTE.getCpf());
        retAgend.enqueue(new Callback<List<Agendamento>>() {
            @Override
            public void onResponse(Call<List<Agendamento>> call, Response<List<Agendamento>> response) {
                agendamentos = response.body();
                initializeRecycle();
            }

            @Override
            public void onFailure(Call<List<Agendamento>> call, Throwable t) {
                Log.e("Meus Agendamento", "ERRRROUUUUUUUUUUUUU: " + t.getMessage());
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        requisicaoAgendamentos();
    }
}
