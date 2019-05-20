package com.ninox.agenda.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Sala;
import com.ninox.agenda.retrofit.RetrofitSalaConfig;
import com.ninox.agenda.ui.onclicklistner.OnItemSalaClickListener;
import com.ninox.agenda.ui.recycle.RecycleSalasAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListaSalasActivity extends AppCompatActivity {

    private String dateSelected;

    private List<Sala> salas;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_salas);
        setTitle("Agendamento - Sala");

//        Sala sala = new Sala();
  //      sala.inicializar();
        salas = new ArrayList<>();

        context = this;

        Call<List<Sala>> retSala = new RetrofitSalaConfig().getSalaService().buscarSalas();
        retSala.enqueue(new Callback<List<Sala>>() {
            @Override
            public void onResponse(Call<List<Sala>> call, Response<List<Sala>> response) {
                salas = response.body();

                Log.e("SalaService", "Quantidade de SALAS: " + salas.size());

                initializeRecycle();
            }

            @Override
            public void onFailure(Call<List<Sala>> call, Throwable t) {
                Log.e("SalaService", "ERRO: "+ t.getMessage());
                Toast.makeText(ListaSalasActivity.this, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    public void initializeRecycle() {

        RecyclerView rv = findViewById(R.id.recycle_view_sala);

        RecycleSalasAdapter recycleSalasAdapter = new RecycleSalasAdapter(salas, context);
        rv.setAdapter(recycleSalasAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);
        //Outro estilo de layout
        //rv.setLayoutManager(new GridLayoutManager(this,3));

        TextView textDataSelecionada = findViewById(R.id.data_selecionada);

        Intent intent = getIntent();
        dateSelected = intent.getStringExtra("dataApresentacao");

        textDataSelecionada.setText("Data selecionada: "+ dateSelected);

        recycleSalasAdapter.setOnItemSalaClickListener(new OnItemSalaClickListener() {
            @Override
            public void onItemClick(Sala sala, int posicao) {
                Intent intentGotToHorario = new Intent(ListaSalasActivity.this, ListaHorarioActivity.class);
                intentGotToHorario.putExtra("sala", sala.getNome());
                intentGotToHorario.putExtra("descricao", sala.getDescricao());
                intentGotToHorario.putExtra("data", dateSelected);
                startActivity(intentGotToHorario);
            }
        });
    }
}
