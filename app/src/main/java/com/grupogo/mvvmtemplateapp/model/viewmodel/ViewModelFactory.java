package com.grupogo.mvvmtemplateapp.model.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

/**
 * Created by jorge_cmata on 18/10/17.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {
    private ItemListViewModel itemListViewModel;

    @Inject
    public ViewModelFactory(ItemListViewModel viewModel) {
        this.itemListViewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ItemListViewModel.class)) {
            return (T) itemListViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}