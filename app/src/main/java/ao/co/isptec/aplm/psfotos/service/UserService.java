package ao.co.isptec.aplm.psfotos.service;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import ao.co.isptec.aplm.psfotos.DTO.LoginDTO;
import ao.co.isptec.aplm.psfotos.model.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserService implements UserServiceInterface{
    private final OkHttpClient cliente = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String baseUrl = "http://e03a.120.220.290.com/api";

    public UserService(){

    }

    public boolean cadastro(User user){
        boolean[] logado = new boolean[1];
        String json = gson.toJson(user);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(baseUrl+"/signup")
                .post(requestBody)
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                logado[0] = false;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                logado[0] = gson.fromJson(responseData, boolean.class);
            }
        });

        return logado[0];
    }

    public boolean login(LoginDTO loginDto){
        boolean[] logado = new boolean[1];

        String json = gson.toJson(loginDto);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(baseUrl+"/login")
                .post(requestBody)
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                logado[0] = false;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                logado[0] = gson.fromJson(responseData, boolean.class);
            }
        });

        return logado[0];
    }

    public List<User> selecionarTodos(){
        List<User>[] listaDeUsers = new List[0];
        Request request = new Request.Builder()
                .url(baseUrl+"/users/all")
                .get()
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                listaDeUsers[0] = null;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                listaDeUsers[0] = gson.fromJson(responseData, List.class);
            }
        });

        return listaDeUsers[0];
    }

    public User selecionarUser(String username){
        User[] user = new User[1];
        Request request = new Request.Builder()
                .url(baseUrl+"/users/"+username)
                .get()
                .build();

        cliente.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                user[0] = null;
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                user[0] = gson.fromJson(responseData, User.class);
            }
        });

        return user[0];
    }


}
