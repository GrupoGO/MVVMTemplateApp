package com.grupogo.mvvmtemplateapp.dagger.components;

import com.grupogo.mvvmtemplateapp.dagger.modules.AppModule;
import com.grupogo.mvvmtemplateapp.ui.items.ItemListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jorge_cmata on 18/10/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(ItemListFragment itemListFragment);

}
