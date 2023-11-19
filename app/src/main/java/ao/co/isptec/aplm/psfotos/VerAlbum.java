package ao.co.isptec.aplm.psfotos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class VerAlbum extends AppCompatActivity {
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_album);
        LinearLayout conteudoLayout = (LinearLayout) findViewById(R.id.conteudoLayout);
        ImageView imagemFoto = (ImageView) findViewById(R.id.imagemFoto);
        ImageView imagemAlbum = (ImageView) findViewById(R.id.imagemAlbum);
        ImageView imagemConta = (ImageView) findViewById(R.id.imagemConta);
        ImageView participantesDoAlbum = (ImageView) findViewById(R.id.verAlbum_participantes);
        ImageView fotoDoAlbum = (ImageView) findViewById(R.id.verAlbum_foto1);
        ImageView adicionarFotoAoAlbum = (ImageView) findViewById(R.id.verAbum_AdicionarFoto);
        TextView tituloFoto = (TextView) findViewById(R.id.verAlbum_tituloDaFoto1);


        participantesDoAlbum.setOnClickListener(v -> {
            ParticipantesDoAlbum dialog = new ParticipantesDoAlbum();
            dialog.show(getSupportFragmentManager(), dialog.getTag());
        });

        ActivityResultLauncher<Intent> activityResultLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            Uri uri = data.getData();
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                                fotoDoAlbum.setImageBitmap(bitmap);
                                try{
                                    FileOutputStream fileOutputStream = new FileOutputStream("imagemNova.png");
                                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                    //fotoDoAlbum.getDrawable();
                                    Drawable drawable = new BitmapDrawable(getResources(), bitmap);
                                    fileOutputStream.close();
                                }catch(IOException e){
                                    e.printStackTrace();
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });

        adicionarFotoAoAlbum.setOnClickListener(V -> {
            Intent intent = new Intent (Intent.ACTION_PICK);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            activityResultLauncher.launch(intent);
        });

        fotoDoAlbum.setOnClickListener(v -> {
            Intent intent = new Intent(this, VerFoto.class);
            startActivity(intent);
        });

        imagemFoto.setOnClickListener(v -> {
            Intent intent = new Intent(this, Foto.class);
            startActivity(intent);
        });

        imagemAlbum.setOnClickListener(v -> {
            Intent intent = new Intent(this, Album.class);
            startActivity(intent);
        });

        imagemConta.setOnClickListener(v -> {
            Intent intent = new Intent(this, Conta.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri imageUri = data.getData();

        try{
            InputStream inputStream = getContentResolver().openInputStream(imageUri);

            //decode the image stream into a bitmap object
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            //PASSANDO OS BITMAP NA IMAGEM
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}