package com.example.kampusku.ApiHelper;

public class UtilsApi {

    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "http://10.0.2.2:8000/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiHelper getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiHelper.class);
    }
}
