package com.ninox.agenda.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.ninox.agenda.R;

public class DataAgendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_agenda);

        Intent dadosRecebidos = getIntent();

        final CalendarView calendarView = findViewById(R.id.calendario);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String dia = String.valueOf(dayOfMonth);
                String mes = String.valueOf(month);
                String ano = String.valueOf(year);

                String dataString = dia +"/"+ mes +"/"+ ano;


                Intent intent = new Intent(DataAgendaActivity.this, ListaSalasActivity.class);
                intent.putExtra("dataLongMiliseconds",dataString);
                startActivity(intent);
            }
        });
    }
}
