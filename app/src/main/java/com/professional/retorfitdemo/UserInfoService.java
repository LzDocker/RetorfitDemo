package com.professional.retorfitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



/**
 * Created by admin on 2017/3/21.
 */

public interface UserInfoService {


    @GET("api/login")
    Call<cashUserBean> getUserinfo(@Query("uid") int uid,@Query("lang")int  lang);


}
