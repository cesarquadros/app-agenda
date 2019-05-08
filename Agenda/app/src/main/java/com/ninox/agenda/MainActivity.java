package com.ninox.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(MainActivity.this, InicialActivity.class);
                startActivity(intentVaiProFormulario);
                Toast.makeText(MainActivity.this, "Usuario Logado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
