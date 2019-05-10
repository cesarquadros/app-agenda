package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.ninox.agenda.R;

import java.util.ArrayList;
import java.util.List;

import model.RVAdapter;
import model.Sala;

public class ListaSalasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_salas);

        Sala sala = new Sala();
        sala.inicializar();
        List<Sala> salas = sala.getSalas();

        RecyclerView rv = findViewById(R.id.teste);

        RVAdapter rvAdapter = new RVAdapter(salas, this);
        rv.setAdapter(rvAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }
}
