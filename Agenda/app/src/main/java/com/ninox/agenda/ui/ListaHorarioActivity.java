package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Horario;
import com.ninox.agenda.retrofit.RetrofitHoraConfig;
import com.ninox.agenda.ui.onclicklistner.OnItemHorarioClickListener;
import com.ninox.agenda.ui.recycle.RecycleHorariosAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaHorarioActivity extends AppCompatActivity {

    private TextView horarioSala;
    private TextView horarioData;

    private String sala;
    private String data;
    private String descricao;

    private List<Horario> horarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_horarios);
        getExtrasIntent();
        inicializarComponents();
        setTitle("Agendamento - Horário");


        Call<List<Horario>> retHorario = new RetrofitHoraConfig().getHorarioService().buscarHorarios(MainActivity.TOKEN,"2019-10-10","1" );

        retHorario.enqueue(new Callback<List<Horario>>() {
            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                horarios = response.body();

                if(horarios != null){
                    initializeRecycle();
                } else {
                    horarios = new ArrayList<>();
                    horarios.add(new Horario("08:00"));
                    horarios.add(new Horario("09:00"));
                    horarios.add(new Horario("10:00"));
                    horarios.add(new Horario("11:00"));
                    horarios.add(new Horario("12:00"));
                    horarios.add(new Horario("13:00"));
                    horarios.add(new Horario("14:00"));
                    horarios.add(new Horario("15:00"));
                    horarios.add(new Horario("16:00"));
                    horarios.add(new Horario("17:00"));
                    horarios.add(new Horario("18:00"));
                    horarios.add(new Horario("19:00"));
                    horarios.add(new Horario("20:00"));
                    initializeRecycle();
                }

            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {
                Log.e("SalaService", "ERRO: "+ t.getMessage());
                Toast.makeText(ListaHorarioActivity.this, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    public void initializeRecycle(){
        RecyclerView rv = findViewById(R.id.recycle_view_horario);

        RecycleHorariosAdapter recycleHorariosAdapter = new RecycleHorariosAdapter(horarios, this);
        rv.setAdapter(recycleHorariosAdapter);

        rv.setLayoutManager(new GridLayoutManager(this,2));

        recycleHorariosAdapter.setOnItemHorarioClickListener(new OnItemHorarioClickListener() {
            @Override
            public void onItemClick(Horario horario, int posicao) {

                Intent intentVaiParaResumo = new Intent(ListaHorarioActivity.this, ResumoAgendamentoActivity.class);
                intentVaiParaResumo.putExtra("data", data);
                intentVaiParaResumo.putExtra("sala", sala);
                intentVaiParaResumo.putExtra("descricao", descricao);
                intentVaiParaResumo.putExtra("horario", horario.getHora());
                startActivity(intentVaiParaResumo);
            }
        });
    }

    private void inicializarComponents(){
        this.horarioSala = findViewById(R.id.horarios_sala_selecionada);
        this.horarioData = findViewById(R.id.horarios_data_selecionada);
        this.horarioData.setText(this.data);
        this.horarioSala.setText(this.sala + " - " + this.descricao);
    }

    private void getExtrasIntent() {
        Intent intentRecebido = getIntent();
        this.sala = intentRecebido.getStringExtra("sala");
        this.data = intentRecebido.getStringExtra("data");
        this.descricao = intentRecebido.getStringExtra("descricao");
    }
}
