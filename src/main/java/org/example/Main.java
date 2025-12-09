package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
//import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        OkHttpClient client = new OkHttpClient();
//        String url="https://jsonplaceholder.typicode.com/todos/1";
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        try (Response response = client.newCall(request).execute()) {
//            if(!response.isSuccessful()){
//                System.out.println("Something went wrong");
//            }
//            System.out.println(response.body().string());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<String> call = service.getPostString();
        try {
            Response response = call.execute();
            if(!response.isSuccessful()){
                System.out.println("something went wrong");
            }else{
                System.out.println(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}