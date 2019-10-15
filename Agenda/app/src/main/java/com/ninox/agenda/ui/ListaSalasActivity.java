package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ninox.agenda.R;
import com.ninox.agenda.model.AgendamentoDTO;
import com.ninox.agenda.model.Sala;
import com.ninox.agenda.retrofit.RetrofitSalaConfig;
import com.ninox.agenda.ui.onclicklistner.OnItemSalaClickListener;
import com.ninox.agenda.ui.recycle.RecycleSalasAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        salas = new ArrayList<>();
        context = this;

        Call<List<Sala>> retSala = new RetrofitSalaConfig().getSalaService().buscarSalas(MainActivity.TOKEN);
        retSala.enqueue(new Callback<List<Sala>>() {
            @Override
            public void onResponse(Call<List<Sala>> call, Response<List<Sala>> response) {
                int code = response.code();

                if(code == 401){
                    Toast.makeText(ListaSalasActivity.this, "Efetue o LOGIN", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ListaSalasActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("EXIT", true);
                    startActivity(intent);
                    return;
                }
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
                intentGotToHorario.putExtra("descricao", sala.getDescricao());
                intentGotToHorario.putExtra("dataExibicao", dateSelected);


                AgendamentoDTO agendamento = new AgendamentoDTO();
                agendamento.setCpfCliente(MainActivity.CLIENTE.getCpf());
                agendamento.setDataAgendamento(stringToDate(dateSelected));
                agendamento.setIdSala(sala.getId());
                agendamento.setStatus(AgendamentoDTO.Status.ABERTO);

                //objeto implementa Serialize para
                intentGotToHorario.putExtra("AgendamentoDTO", agendamento);
                intentGotToHorario.putExtra("Sala", sala);

                startActivity(intentGotToHorario);
            }
        });
    }

    public String stringToDate(String dataStr){
        try {
            SimpleDateFormat simpleDateFormatView = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat simpleDateFormatReq = new SimpleDateFormat("yyyy-MM-dd");

            Date date = simpleDateFormatView.parse(dateSelected);

            String dateStrReq = simpleDateFormatReq.format(date);

            return dateStrReq;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
