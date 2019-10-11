package com.ninox.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
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
    public static String TOKEN;

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
                autenticacao(user, pass);
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

                if(response.code() == 200){
                    Token token = response.body();
                    TOKEN = token.getUuidKey();
                    Intent intentVaiProFormulario = new Intent(MainActivity.this, MeusAgendamentosActivity.class);
                    startActivity(intentVaiProFormulario);
                    Toast.makeText(MainActivity.this, "Usuario Logado", Toast.LENGTH_SHORT).show();
                } else if (response.code() == 401) {
                    Toast.makeText(MainActivity.this, "Usuario ou senha invalidos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Ops! Ocorreu um erro ao efetuar o login", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("Login", "ERRROOOOOOOOOOOOOOOOOOOOOU: " + t.getMessage());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
