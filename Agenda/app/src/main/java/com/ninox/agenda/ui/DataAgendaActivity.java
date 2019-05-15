package com.ninox.agenda.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.ninox.agenda.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class  DataAgendaActivity extends AppCompatActivity {

    private static final String FORMATO_DATA_APRESENTACAO = "dd/MM/yyyy";
    private static final String FORMATO_DATA_REQUISICAO = "yyyy-MM-dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_agenda);
        setTitle("Agendamento - Data"); //---- Alterar titulo da Activity

        Intent dadosRecebidos = getIntent();

        final CalendarView calendarView = findViewById(R.id.calendario);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                view = getDateString(view, year, month, dayOfMonth);

                String dataStringApresentacao = new SimpleDateFormat(FORMATO_DATA_APRESENTACAO).format(new Date(view.getDate()));
                String dataStringRequisicao = new SimpleDateFormat(FORMATO_DATA_REQUISICAO).format(new Date(view.getDate()));

                Intent intent = new Intent(DataAgendaActivity.this, ListaSalasActivity.class);
                intent.putExtra("dataApresentacao",dataStringApresentacao);
                intent.putExtra("dataRequisicao",dataStringRequisicao);
                startActivity(intent);
            }
        });
    }

    public CalendarView getDateString(CalendarView view, int year, int month, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        view.setDate(calendar.getTimeInMillis());
        return view;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
}
