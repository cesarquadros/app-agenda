package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Token;
import com.ninox.agenda.retrofit.RetrofitLoginConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String user;
    private String pass;
    private EditText editTextUser;
    private EditText editTextPass;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Agendamento - Login");
        initComponents();

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                user = editTextUser.getText().toString();
                pass = editTextPass.getText().toString();

                String token = autenticacao(user, pass);

                Intent intentVaiProFormulario = new Intent(MainActivity.this, MeusAgendamentosActivity.class);
                startActivity(intentVaiProFormulario);
                Toast.makeText(MainActivity.this, "Usuario Logado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String autenticacao(String user, String pass){

        Call<Token> retLogin = new RetrofitLoginConfig().autenticar().autenticacao(user, pass);

        retLogin.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Log.e("Login", "TOKEN: " + response.body());
                Log.e("Login", "STATUS CODE: " + response.code());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("Login", "ERRROOOOOOOOOOOOOOOOOOOOOU: " + t.getMessage());
            }
        });

        return null;
    }


    private void initComponents(){
        editTextUser = findViewById(R.id.login_usuario);
        editTextPass = findViewById(R.id.login_senha);
        btnLogin = findViewById(R.id.btn_login);
    }
}
