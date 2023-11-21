package ao.co.isptec.aplm.psfotos.service;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import ao.co.isptec.aplm.psfotos.DTO.AlbumUsersDto;
import ao.co.isptec.aplm.psfotos.model.Album;
import ao.co.isptec.aplm.psfotos.model.AlbumUsers;
import ao.co.isptec.aplm.psfotos.model.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;

public class AlbumService implements AlbumServiceInterface{
    private final OkHttpClient cliente = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String baseUrl = "http://e03a.120.220.290.com/api";
    public boolean criarAlbum(Album album, String username){
        boolean [] criado = new boolean[1];
        String json = gson.toJson(album);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(baseUrl+"/users/"+username+"/albums/create")
                .post(requestBody)
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                criado[0] = false;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                criado[0] = gson.fromJson(responseData, Boolean.class);
                
            }
        });

        return criado[0];
    }

    public boolean adicionarParticipantesAoAlbum(String username, long albumId, AlbumUsersDto usersDto){
        boolean adicionado[] = new boolean[1];
        String json = gson.toJson(usersDto);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(baseUrl+"/users/"+username+"/albums/"+albumId+"/participants/add")
                .post(requestBody)
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                adicionado[0] = false;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                adicionado[0] = gson.fromJson(responseData, Boolean.class);
            }
        });

        return adicionado[0];
    }

    public List<User> participantesDoAlbum(long albumId, String username){
        List<User> participantes[] = new List[1];
        Request request = new Request.Builder()
                .url(baseUrl+"/users/"+username+"/albums/"+albumId+"/participants")
                .get()
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                participantes[0] = null;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                participantes[0] = gson.fromJson(responseData, List.class);
            }
        });

        return participantes[0];
    }

    public List<AlbumUsers> usersDeTodosAlbumsNaNuvem(){
        List<AlbumUsers> participantes[] = new List[1];
        Request request = new Request.Builder()
                .url(baseUrl+"/albums/users")
                .get()
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                participantes[0] = null;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                participantes[0] = gson.fromJson(responseData, List.class);
            }
        });

        return participantes[0];
    }


    public List<Album> myAlbums(String username){
        List<Album> myAlbums[] = new List[1];
        Request request = new Request.Builder()
                .url(baseUrl+"/users/"+username+"/albums/myalbums")
                .get()
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                myAlbums[0] = null;
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                myAlbums[0] = gson.fromJson(responseData, List.class);
            }
        });

        return myAlbums[0];
    }
}
