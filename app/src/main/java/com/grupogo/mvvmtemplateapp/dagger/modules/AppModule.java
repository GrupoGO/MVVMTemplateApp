package com.grupogo.mvvmtemplateapp.dagger.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.grupogo.mvvmtemplateapp.data.repository.ItemRepository;
import com.grupogo.mvvmtemplateapp.data.repository.ItemRepositoryImpl;
import com.grupogo.mvvmtemplateapp.data.server.ApiService;
import com.grupogo.mvvmtemplateapp.model.viewmodel.ItemListViewModel;
import com.grupogo.mvvmtemplateapp.model.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by jorge_cmata on 18/10/17.
 */

@Module
public class AppModule {

    public static final String BASE_URL = "http://www.thecocktaildb.com/api/json/v1/1/";

    @Provides
    @Singleton
    ApiService provideApiService() {
        return new retrofit2.Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(ApiService.class);

    }

    @Provides
    @Singleton
    ItemRepository provideItemRepository(ItemRepositoryImpl repository) {
        return repository;
    }

    @Provides
    ViewModel provideListIssuesViewModel(ItemListViewModel viewModel) {
        return viewModel;
    }

    @Provides
    ViewModelProvider.Factory provideListIssuesViewModelFactory(
            ViewModelFactory factory
    ) {
        return factory;
    }



}
