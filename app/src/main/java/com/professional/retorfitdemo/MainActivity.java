package com.professional.retorfitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

     public void get(View view){

         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl("http://www.cashify.co/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         UserInfoService userInfoService = retrofit.create(UserInfoService.class);

         Call<cashUserBean> call = userInfoService.getUserinfo(10064,2);
         call.enqueue(new Callback<cashUserBean>() {
             @Override
             public void onResponse(Call<cashUserBean> call, Response<cashUserBean> response) {

                 Toast.makeText(MainActivity.this, "onResponse",Toast.LENGTH_LONG).show();
                 cashUserBean c  = response.body();
                 Toast.makeText(MainActivity.this, c.getCoin()+"---------",Toast.LENGTH_LONG).show();
             }

             @Override
             public void onFailure(Call<cashUserBean> call, Throwable t) {

             }
         });

     }


    public void get2(View view){


        Toast.makeText(MainActivity.this, "onResponse",Toast.LENGTH_LONG).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.cashify.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInfoService2 exploreListService = retrofit .create(UserInfoService2.class);
         Call <cashUserBean>call = exploreListService.getUserinfo("api",10064 ,2);
         call.enqueue(new Callback<cashUserBean>() {
            @Override
            public void onResponse(Call<cashUserBean> call, Response<cashUserBean> response) {

                Toast.makeText(MainActivity.this, "onResponse",Toast.LENGTH_LONG).show();
                cashUserBean c  = response.body();
                Toast.makeText(MainActivity.this, c.getCoin()+"---------",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<cashUserBean> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure"+ t.getMessage(),Toast.LENGTH_LONG).show();

                Log.i("onFailure",t.getMessage());

            }
        });
    }





}
