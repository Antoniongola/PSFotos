package ao.co.isptec.aplm.psfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Foto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        LinearLayout conteudoLayout = (LinearLayout) findViewById(R.id.conteudoLayout);
        ImageView imagemAlbum = (ImageView) findViewById(R.id.imagemAlbum);
        ImageView imagemConta = (ImageView) findViewById(R.id.imagemConta);
        ImageView foto = (ImageView) findViewById(R.id.foto_foto1);

        foto.setOnClickListener(V -> {
            Intent intent = new Intent (this, VerFoto.class);
            intent.putExtra("","");
            startActivity(intent);
        });

        imagemAlbum.setOnClickListener(v -> {
            abrirAlbum();
        });

        imagemConta.setOnClickListener(v -> {
            abrirConta();
        });

        /*
        for (int i = 2; i <= 5; i++) {
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
            ///*
            conteudoLayout.addView(imageView);
            conteudoLayout.addView(textView);
            //*/
            /*
        }
        */
    }
    public void abrirConta(){
        Intent intent = new Intent(this, Conta.class);
        startActivity(intent);
    }

    public void abrirAlbum(){
        Intent intent = new Intent(this, Album.class);
        startActivity(intent);
    }
}