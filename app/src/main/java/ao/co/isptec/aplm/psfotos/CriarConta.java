package ao.co.isptec.aplm.psfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//classe pro cadastro
public class CriarConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("sessao", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean logado = sharedPreferences.getBoolean("loggedIn", false);
        if(!logado) {
            setContentView(R.layout.activity_criarconta);
            Button cadastrar = (Button) findViewById(R.id.signupButton);
            EditText signupNome = (EditText) findViewById(R.id.signupNome);
            EditText signupUsername = (EditText) findViewById(R.id.signupUsername);
            EditText signupPassword = (EditText) findViewById(R.id.signupPassword);
            TextView login = (TextView) findViewById(R.id.login);

        /*
        login.setOnClickListener(v -> {
            mensagemDeErro.setText("NENHUM CAMPO PODE SER NULO, PREENCHA!");
        });
        */
            cadastrar.setOnClickListener(V -> {
                if (signupNome.getText().toString() != null && signupUsername.getText().toString() != null && signupPassword.getText().toString() != null) {
                    editor.putString("nome", signupNome.getText().toString());
                    editor.putString("username", signupUsername.getText().toString());
                    editor.putString("password", signupPassword.getText().toString());
                    editor.putBoolean("loggedIn", true);
                    editor.apply();
                    Intent intent = new Intent(this, Album.class);
                    startActivity(intent);

                }
            });
            login.setOnClickListener(v -> abrirLogin());
        }else{
            Intent intent = new Intent(this, Album.class);
            startActivity(intent);
        }
    }

    public void abrirLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}