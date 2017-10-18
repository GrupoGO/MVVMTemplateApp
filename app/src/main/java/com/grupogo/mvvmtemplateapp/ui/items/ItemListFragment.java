package com.grupogo.mvvmtemplateapp.ui.items;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.grupogo.mvvmtemplateapp.R;
import com.grupogo.mvvmtemplateapp.TemplateApplication;
import com.grupogo.mvvmtemplateapp.model.datamodel.Item;
import com.grupogo.mvvmtemplateapp.model.viewmodel.ItemListViewModel;

import java.util.List;

import javax.inject.Inject;

public class ItemListFragment extends Fragment {

    private ItemListAdapter adapter;
    @Inject ViewModelProvider.Factory mViewModelFactory;

    ItemListViewModel itemListViewModel;

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
        ((TemplateApplication)getActivity().getApplication()).getAppComponent().inject(this);
        itemListViewModel = ViewModelProviders.of(getActivity(), mViewModelFactory).get(ItemListViewModel.class);
        itemListViewModel.init();
        itemListViewModel.getItems().observe(this, response ->  {
            if(response.getData()!=null){
                handleSuccess((List<Item>) response.getData());
            } else {
                handleError(response.getError());
            }
        });
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
    }

    public void handleSuccess(List<Item> items){
        if (items!=null) {
            adapter.setDataSet(items);
        }
    }

    public void handleError(Throwable t){
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
