package com.example.kampusku.ApiHelper;

import com.example.kampusku.Kampus.GetKampus;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiHelper {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> registerRequest(@Field("name") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password,
                                       @Field("c_password") String c_password);

    @GET("kampus/")
    Call<GetKampus> getKampus();

    @GET("kampus/search/{nama_univ}")
    Call<GetKampus> getKampus(@Path("nama_univ") String nama_univ);


}
