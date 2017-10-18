package com.grupogo.mvvmtemplateapp.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.grupogo.mvvmtemplateapp.data.server.ApiService;
import com.grupogo.mvvmtemplateapp.data.server.JSONParseHelper;
import com.grupogo.mvvmtemplateapp.model.datamodel.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by jorge_cmata on 17/10/17.
 */

public class UserRepository {

    private ApiService apiService;

    public void getItems(Observer<List<Item>> observer){

        apiService.requestItems("Cocktail")
                .subscribeOn(Schedulers.io())
                .map(response -> {
                   /** if(response.isSuccessful()){
                        return JSONParseHelper.parseResponse(response.body());
                    } else {
                        //Error
                        return new Throwable("Server Error");
                    }**/
                    return JSONParseHelper.parseResponse(response.body());
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }



}
