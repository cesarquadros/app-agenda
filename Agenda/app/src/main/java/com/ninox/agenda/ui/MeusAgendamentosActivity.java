package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ninox.agenda.R;

public class MeusAgendamentosActivity extends AppCompatActivity {

    private Button btnNovoAgendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_agendamentos);

        this.btnNovoAgendamento = findViewById(R.id.btn_novo_agendamento);

        this.btnNovoAgendamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDate = new Intent(MeusAgendamentosActivity.this, DataAgendaActivity.class);
                startActivity(goDate);
            }
        });
    }
}
