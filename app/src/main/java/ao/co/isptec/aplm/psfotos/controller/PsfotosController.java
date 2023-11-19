package ao.co.isptec.aplm.psfotos.controller;

import ao.co.isptec.aplm.psfotos.model.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PsfotosController {
    private final Retrofit retrofit;
    public PsfotosController(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public User getUserByUsername(){
        Retrofit api = this.retrofit.create(Retrofit.class);
        return null;
    }
}
