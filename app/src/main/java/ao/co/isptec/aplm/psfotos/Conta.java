package ao.co.isptec.aplm.psfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ao.co.isptec.aplm.psfotos.controller.PsfotosController;
import ao.co.isptec.aplm.psfotos.model.User;

public class Conta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("sessao", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        setContentView(R.layout.activity_conta);
        final PsfotosController api = new PsfotosController();
        Button logoutButton = (Button) findViewById(R.id.logoutButton);
        ImageView imagemFoto = (ImageView) findViewById(R.id.imagemFoto);
        ImageView imagemAlbum = (ImageView) findViewById(R.id.imagemAlbum);
        TextView contaUsername = (TextView) findViewById(R.id.contaUsername);
        String username = sharedPreferences.getString("username", null);
        //User user = api.selecionarUser(username);
        contaUsername.setText(username);

        logoutButton.setOnClickListener(V -> {
            editor.clear();
            editor.apply();
            this.sair(V);
        });

        imagemFoto.setOnClickListener(v -> {
            abrirFoto();
        });

        imagemAlbum.setOnClickListener(v -> {
            abrirAlbum();
        });
    }
    public void abrirAlbum(){
        Intent intent = new Intent(this, Album.class);
        startActivity(intent);
    }

    public void abrirFoto(){
        Intent intent = new Intent(this, Foto.class);
        startActivity(intent);
    }

    public void sair(View view){
        Intent intent = new Intent(this, CriarConta.class);
        startActivity(intent);
    }
}