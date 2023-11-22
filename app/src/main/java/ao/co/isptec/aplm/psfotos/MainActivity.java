package ao.co.isptec.aplm.psfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//cor cinza FF706D6D
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("sessao", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Button login = (Button) findViewById(R.id.loginButton);
        EditText loginUsername = (EditText) findViewById(R.id.loginUsername);
        EditText loginPassword = (EditText) findViewById(R.id.loginPassword);
        TextView cadastrar = (TextView) findViewById(R.id.cadastrar);
        TextView mensagemDeErro = (TextView) findViewById(R.id.mensagemDeErro);
        login.setOnClickListener(v -> {
            String username = String.valueOf(loginUsername.getText());
            String password = String.valueOf(loginPassword.getText());
            editor.putString("username", username);
            editor.putString("password", password);
            editor.putBoolean("logged_in", true);
            editor.apply();
            Intent intent = new Intent(this, Album.class);
            startActivity(intent);
        });

        cadastrar.setOnClickListener(v -> abrirCriarConta());
    }

    public void abrirCriarConta(){
        Intent intent = new Intent(this, CriarConta.class);
        startActivity(intent);
    }

    public void abrirHomepage(){
        Intent intent = new Intent(this, Album.class);
        startActivity(intent);
    }
}