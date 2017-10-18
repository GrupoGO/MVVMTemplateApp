package com.grupogo.mvvmtemplateapp.model.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.grupogo.mvvmtemplateapp.data.repository.ItemRepository;
import com.grupogo.mvvmtemplateapp.model.datamodel.Item;
import com.grupogo.mvvmtemplateapp.model.datamodel.ViewModelResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by carlosolmedo on 17/10/17.
 */

public class ItemListViewModel extends ViewModel {

    private MutableLiveData<ViewModelResponse> response;
    private ItemRepository repository;

    @Inject
    public ItemListViewModel(ItemRepository repository) {
        this.repository = repository;
    }

    public void init() {
        if(response!=null){
            return;
        }
        response = new MutableLiveData<>();
        repository.getItems(new Observer<List<Item>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {}

            @Override
            public void onNext(@NonNull List<Item> items) {
                response.setValue(new ViewModelResponse(items));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                response.setValue(new ViewModelResponse(e));
            }

            @Override
            public void onComplete() {}
        });
    }

    public LiveData<ViewModelResponse> getItems() {
            return response;
    }
}
