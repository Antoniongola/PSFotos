package ao.co.isptec.aplm.psfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Conta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
        Button logoutButton = (Button) findViewById(R.id.logoutButton);
        ImageView imagemFoto = (ImageView) findViewById(R.id.imagemFoto);
        ImageView imagemAlbum = (ImageView) findViewById(R.id.imagemAlbum);

        TextView textoFoto = (TextView) findViewById(R.id.textoFoto);
        TextView textoAlbum = (TextView) findViewById(R.id.textoAlbum);

        imagemFoto.setOnClickListener(v -> {
            abrirFoto();
        });

        textoFoto.setOnClickListener(v -> {
            abrirFoto();
        });

        imagemAlbum.setOnClickListener(v -> {
            abrirAlbum();
        });

        textoAlbum.setOnClickListener(v -> {
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