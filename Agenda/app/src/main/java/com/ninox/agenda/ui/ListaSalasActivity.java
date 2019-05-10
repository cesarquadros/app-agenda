package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ninox.agenda.R;
import com.ninox.agenda.model.OnItemClickListener;
import com.ninox.agenda.model.RVAdapter;

import java.util.List;

import model.Sala;

public class ListaSalasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_salas);

        Sala sala = new Sala();
        sala.inicializar();
        List<Sala> salas = sala.getSalas();

        RecyclerView rv = findViewById(R.id.recycle_view);

        RVAdapter rvAdapter = new RVAdapter(salas, this);
        rv.setAdapter(rvAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        rvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Sala sala, int posicao) {
                Toast.makeText(ListaSalasActivity.this, "Escolhida sala: ", Toast.LENGTH_SHORT).show();
                Intent intentVaiPraData = new Intent(ListaSalasActivity.this, DataAgendaActivity.class);
                intentVaiPraData.putExtra("sala", sala.getNome());
                intentVaiPraData.putExtra("descricao", sala.getDescricao());
                startActivity(intentVaiPraData);
            }
        });
    }
}
