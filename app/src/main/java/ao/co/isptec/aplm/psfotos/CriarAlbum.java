package ao.co.isptec.aplm.psfotos;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {newInstance} factory method to
 * create an instance of this fragment.
 */
public class CriarAlbum extends DialogFragment implements CriarAlbumInterface{
    private VerAlbum bindingVerAlbum;
    private CriarAlbumInterface callback;

    public void setCallback(CriarAlbumInterface callback){
        this.callback = callback;
    }

    public CriarAlbum() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_criar_album, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText nomeDoAlbum = (EditText) this.getView().findViewById(R.id.criarAlbum_titulo);
        Button criarAlbumNovo = (Button) this.getView().findViewById(R.id.criarAlbumButton);
        criarAlbumNovo.setOnClickListener(V -> {
            //callback.dadosRecebido(nomeDoAlbum.getText().toString());
            /*
            if(nomeDoAlbum.getText().toString() != null){
                TextView tituloAlbum = (TextView) bindingVerAlbum.findViewById(R.id.album_tituloDoAlbum);
                tituloAlbum.setText(nomeDoAlbum.getText().toString());
            }
            */
            dismiss();
        });
    }

    @Override
    public void dadosRecebido(String nome) {
        /*
        EditText nomeDoAlbum = (EditText) this.getView().findViewById(R.id.criarAlbum_titulo);
        nomeDoAlbum.setText(nome);*/
    }
}