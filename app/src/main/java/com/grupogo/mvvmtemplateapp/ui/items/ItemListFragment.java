package com.grupogo.mvvmtemplateapp.ui.items;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grupogo.mvvmtemplateapp.R;
import com.grupogo.mvvmtemplateapp.model.datamodel.Item;
import com.grupogo.mvvmtemplateapp.model.viewmodel.ItemListViewModel;

import java.util.List;

public class ItemListFragment extends Fragment {

    private ItemListAdapter adapter;
    private ItemListViewModel itemListViewModel;

    public static ItemListFragment newInstance() {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        itemListViewModel = ViewModelProviders.of(this).get(ItemListViewModel.class);
        itemListViewModel.init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        adapter = new ItemListAdapter(getContext());
        recyclerView.setAdapter(adapter);

        itemListViewModel.getItems().observe(this, new Observer<List<Item>>() {

            @Override
            public void onChanged(@Nullable List<Item> items) {
                if (items!=null) {
                    adapter.setDataSet(items);
                }
            }
        });
    }
}
