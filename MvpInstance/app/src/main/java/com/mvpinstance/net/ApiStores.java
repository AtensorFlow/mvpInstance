package com.mvpinstance.net;


import com.mvpinstance.mvp.main.MainModel;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "https://www.cloudn8c.cn/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Call<MainModel> loadDataByRetrofit(@Path("cityId") String cityId);

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> loadDataByRetrofitRxJava(@Path("cityId") String cityId);

    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("vdyweb/ws/rest/Login")
    Call<ResponseBody>getMessage(@Body RequestBody info);   // 请求RequestBody 类型



    @GET("active?machinename={machinename}&libraryId={libraryId}&machinelocal={machinelocal}")
    Observable<MainModel> checkNewVersion(@Path("machinename") String machinename,
                                    @Path("libraryId") String libraryId,
                                    @Path("machinelocal") String machinelocal);



}
