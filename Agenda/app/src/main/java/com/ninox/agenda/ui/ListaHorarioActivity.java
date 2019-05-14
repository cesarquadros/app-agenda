package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Horario;
import com.ninox.agenda.ui.onclicklistner.OnItemHorarioClickListener;
import com.ninox.agenda.ui.recycle.RecycleHorariosAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaHorarioActivity extends AppCompatActivity {

    private String sala;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_horarios);

        List<Horario> horarios = new ArrayList<>();
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

        RecyclerView rv = findViewById(R.id.recycle_view_horario);

        RecycleHorariosAdapter recycleHorariosAdapter = new RecycleHorariosAdapter(horarios, this);
        rv.setAdapter(recycleHorariosAdapter);

        rv.setLayoutManager(new GridLayoutManager(this,2));

        recycleHorariosAdapter.setOnItemHorarioClickListener(new OnItemHorarioClickListener() {
            @Override
            public void onItemClick(Horario horario, int posicao) {

                Intent intentRecebido = getIntent();

                Intent intentVaiParaResumo = new Intent(ListaHorarioActivity.this, ResumoAgendamentoActivity.class);
                intentVaiParaResumo.putExtra("data", intentRecebido.getStringExtra("data"));
                intentVaiParaResumo.putExtra("sala", intentRecebido.getStringExtra("sala"));
                intentVaiParaResumo.putExtra("descricao", intentRecebido.getStringExtra("descricao"));
                intentVaiParaResumo.putExtra("horario", horario.getHora());
                startActivity(intentVaiParaResumo);
            }
        });
    }
}
