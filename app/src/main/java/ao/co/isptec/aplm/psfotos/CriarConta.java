package ao.co.isptec.aplm.psfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//classe pro cadastro
public class CriarConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        login.setOnClickListener(v -> abrirLogin());
    }

    public void abrirLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}