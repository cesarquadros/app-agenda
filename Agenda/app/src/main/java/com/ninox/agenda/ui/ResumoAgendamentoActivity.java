package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Agendamento;
import com.ninox.agenda.model.AgendamentoDTO;
import com.ninox.agenda.model.Sala;
import com.ninox.agenda.retrofit.RetrofitAgendamentoConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResumoAgendamentoActivity extends AppCompatActivity {

    private TextView resumoSala;
    private TextView resumoHorario;
    private TextView resumoData;
    private Button btnConfirmarReserva;
    private String data;

    private Sala sala;

    private AgendamentoDTO agendamentoDTO;

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

                Call<Agendamento> agendar = new RetrofitAgendamentoConfig().agendamento().agendar(MainActivity.TOKEN, agendamentoDTO);
                agendar.enqueue(new Callback<Agendamento>() {
                    @Override
                    public void onResponse(Call<Agendamento> call, Response<Agendamento> response) {
                        Log.e("Agendar", "Retorno Agendamento: " + response.body());
                        Toast.makeText(ResumoAgendamentoActivity.this, "Agendamento Realizado com sucesso!!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Agendamento> call, Throwable t) {
                        Log.e("Agendar", "Quantidade de SALAS: " + t.getMessage());
                    }
                });

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
        this.data = intent.getStringExtra("dataExibicao");
        this.agendamentoDTO = (AgendamentoDTO) getIntent().getSerializableExtra("AgendamentoDTO");
        this.sala = (Sala) getIntent().getSerializableExtra("Sala");
    }

    private void setDadosComponents() {
        this.resumoData.setText("Data: " + this.data);
        this.resumoHorario.setText("Horario: " + this.agendamentoDTO.getHora());
        this.resumoSala.setText(this.sala.getNome() + " - " + this.sala.getDescricao());
    }
}
