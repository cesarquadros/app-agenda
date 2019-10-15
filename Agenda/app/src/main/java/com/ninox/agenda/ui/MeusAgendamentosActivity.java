package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Agendamento;
import com.ninox.agenda.model.Sala;
import com.ninox.agenda.ui.recycle.RecycleAgendamentosAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeusAgendamentosActivity extends AppCompatActivity {

    private Button btnNovoAgendamento;
    private Context context;
    private List<Agendamento> agendamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agendamentos);

        this.context = this;
        agendamentos = new ArrayList<>();
        initializeRecycle();

        this.btnNovoAgendamento = findViewById(R.id.btn_novo_agendamento);
        this.btnNovoAgendamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDate = new Intent(MeusAgendamentosActivity.this, DataAgendaActivity.class);
                startActivity(goDate);
            }
        });
    }

    public void initializeRecycle(){
        RecyclerView rv = findViewById(R.id.recycle_view_agendamentos);
        Agendamento a = new Agendamento();

        Sala s = new Sala();
        s.setNome("Sala 1");
        s.setDescricao("3 Cadeiras");

        a.setDataAgendamento(new Date());
        a.setSala(s);

        agendamentos.add(a);

        RecycleAgendamentosAdapter recycleAgendamentosAdapter = new RecycleAgendamentosAdapter(agendamentos, context);
        rv.setAdapter(recycleAgendamentosAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);



    }
}
