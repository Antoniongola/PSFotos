package ao.co.isptec.aplm.psfotos.service;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;

import ao.co.isptec.aplm.psfotos.model.Photo;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PhotoService implements PhotoServiceInterface{
    private final OkHttpClient cliente = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String baseUrl = "http://e03a.120.220.290.com/api";

    //método post
    public Photo adicionarFotoAoAlbum(String username, String nomeDaFoto, long albumId){
        Photo photo[] = new Photo[1];
        String json = gson.toJson(username);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(baseUrl+"/")
                .post(requestBody)
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                photo[0] = null;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                photo[0] = gson.fromJson(responseData, Photo.class);
            }
        });

        return photo[0];
    }
}
