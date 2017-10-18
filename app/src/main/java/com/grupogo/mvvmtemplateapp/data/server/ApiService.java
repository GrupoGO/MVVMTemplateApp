package com.grupogo.mvvmtemplateapp.data.server;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by jorge_cmata on 17/10/17.
 */
public interface ApiService {

    @retrofit2.http.POST("filter.php")
    Observable<Response<String>> requestItems(@retrofit2.http.Query("c") String query);
}
