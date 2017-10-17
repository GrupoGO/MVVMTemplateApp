package com.grupogo.mvvmtemplateapp.model.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.grupogo.mvvmtemplateapp.model.datamodel.Item;

import java.util.List;

/**
 * Created by carlosolmedo on 17/10/17.
 */

public class ItemListViewModel extends ViewModel {

    private LiveData<List<Item>> items;

    public void init() {

    }

    public LiveData<List<Item>> getItems() {
        return items;
    }
}
