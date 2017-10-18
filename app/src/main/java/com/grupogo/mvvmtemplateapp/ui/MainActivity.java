package com.grupogo.mvvmtemplateapp.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.grupogo.mvvmtemplateapp.R;
import com.grupogo.mvvmtemplateapp.ui.items.ItemListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bindToolbar();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, ItemListFragment.newInstance(), "ItemListFragment")
                .commit();
    }

    private void bindToolbar(){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle("MVVM Template App");
        }
    }
}
