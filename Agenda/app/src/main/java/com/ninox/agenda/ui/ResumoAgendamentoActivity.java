package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ninox.agenda.R;

public class ResumoAgendamentoActivity extends AppCompatActivity {

    private TextView resumoSala;
    private TextView resumoHorario;
    private TextView resumoData;
    private Button btnConfirmarReserva;

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

        this.btnConfirmarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataAgendaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });
    }

    public void inicializarComponentes(){
        this.resumoData = findViewById(R.id.resumo_data);
        this.resumoHorario = findViewById(R.id.resumo_horario);
        this.resumoSala = findViewById(R.id.resumo_sala);
        this.btnConfirmarReserva = findViewById(R.id.btn_confirmar_reserva);
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
