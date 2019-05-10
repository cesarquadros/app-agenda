package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ninox.agenda.R;

public class DataAgendaActivity extends AppCompatActivity {

    private TextView salaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_agenda);

        Intent dadosRecebidos = getIntent();

        salaSelecionada = findViewById(R.id.sala_selecionada);

       // String dadosRecebidos.getIntExtra("sala", 1)

       String sala = dadosRecebidos.getStringExtra("sala");
       String descricao = dadosRecebidos.getStringExtra("descricao");

       salaSelecionada.setText(sala);
    }
}
