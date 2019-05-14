package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ninox.agenda.R;

public class ResumoAgendamentoActivity extends AppCompatActivity {

    private TextView resumoSala;
    private TextView resumoHorario;
    private TextView resumoData;

    private String sala;
    private String horario;
    private String data;
    private String descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_agendamento);
        setTitle("Agendamento - Resumo");
        inicializarComponentes();
        getExtrasIntent();
        setDadosComponents();

        Toast.makeText(ResumoAgendamentoActivity.this, "Tela de resumo do Agendamento", Toast.LENGTH_LONG).show();
    }

    public void inicializarComponentes(){
        this.resumoData = findViewById(R.id.resumo_data);
        this.resumoHorario = findViewById(R.id.resumo_horario);
        this.resumoSala = findViewById(R.id.resumo_sala);
    }

    public void getExtrasIntent(){
        Intent intent = getIntent();
        this.sala = intent.getStringExtra("sala");
        this.horario = intent.getStringExtra("horario");
        this.data = intent.getStringExtra("data");
        this.descricao = intent.getStringExtra("descricao");
    }

    private void setDadosComponents() {
        this.resumoData.setText("Data: " + this.data);
        this.resumoHorario.setText("Horario: " + this.horario);
        this.resumoSala.setText(this.sala + " - " + descricao);
    }
}
