package com.grupogo.mvvmtemplateapp.data.repository;

import com.grupogo.mvvmtemplateapp.data.server.ApiService;
import com.grupogo.mvvmtemplateapp.data.server.JSONParseHelper;
import com.grupogo.mvvmtemplateapp.model.datamodel.Item;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jorge_cmata on 18/10/17.
 */

public class ItemRepositoryImpl implements ItemRepository{

    @Inject
    ApiService apiService;

    @Inject
    public ItemRepositoryImpl() {}

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
