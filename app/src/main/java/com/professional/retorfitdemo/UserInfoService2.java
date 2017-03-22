package com.professional.retorfitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by admin on 2017/3/21.
 */

public interface UserInfoService2 {


    @GET("{aaa}/login")
    Call<cashUserBean> getUserinfo(@Path("aaa")String aaa,@Query("uid") int uid, @Query("lang") int lang);


}
