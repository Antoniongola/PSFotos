package ao.co.isptec.aplm.psfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Album extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        LinearLayout conteudoLayout = (LinearLayout) findViewById(R.id.conteudoLayout);
        ImageView imagemFoto = (ImageView) findViewById(R.id.imagemFoto);
        ImageView imagemAlbum = (ImageView) findViewById(R.id.imagemAlbum);
        ImageView imagemConta = (ImageView) findViewById(R.id.imagemConta);
        ImageView criarAlbum = (ImageView) findViewById(R.id.Album_addAlbumIcon);
        ImageView album = (ImageView) findViewById(R.id.album_album1);
        TextView tituloDoAlbum = (TextView) findViewById(R.id.album_tituloDoAlbum);
        tituloDoAlbum.setText("teste maluco");

        CriarAlbumInterface criarAlbumInterface = new CriarAlbumInterface() {
            @Override
            public void dadosRecebido(String nome) {
                receberNome(nome);
            }
        };

        album.setOnClickListener(v -> {
            Intent intent = new Intent(this, VerAlbum.class);
            startActivity(intent);
        });

        criarAlbum.setOnClickListener(v -> {
            CriarAlbum dialog = new CriarAlbum();
            dialog.show(getSupportFragmentManager(), dialog.getTag());

        });

        imagemFoto.setOnClickListener(v -> {
            abrirFoto();
        });

        imagemConta.setOnClickListener(v -> {
            abrirConta();
        });

        /*
        for (int i = 3; i <= 5; i++) {
            LinearLayout layoutVertical = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutVertical.getLayoutParams();

            //criando as propriedades do layout
            layoutVertical.setOrientation(LinearLayout.VERTICAL);
            layoutParams.setMargins(10,0,0,10);
            layoutParams.height =LinearLayout.LayoutParams.WRAP_CONTENT;
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;

            //passando todas propriedades pro nosso layout
            layoutVertical.setLayoutParams(layoutParams);

            //criando a nossa imagem
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.album);

            //criando nosso texto
            TextView textView = new TextView(this);
            textView.setText("Album " + i);

            //adicionando a imagem e o texto ao layout
            layoutVertical.addView(imageView);
            layoutVertical.addView(textView);

            //adicionando o novo layout ao layout ja existente
            conteudoLayout.addView(layoutVertical);
            conteudoLayout.requestLayout();

            //
            conteudoLayout.addView(imageView);
            conteudoLayout.addView(textView);

        }
        */
    }
    public void abrirConta(){
        Intent intent = new Intent(this, Conta.class);
        startActivity(intent);
    }

    public void abrirFoto(){
        Intent intent = new Intent(this, Foto.class);
        startActivity(intent);
    }

    public void receberNome(String tituloDoAlbum) {
        TextView titulo = (TextView) findViewById(R.id.album_tituloDoAlbum);
        titulo.setText(tituloDoAlbum);
    }
}
