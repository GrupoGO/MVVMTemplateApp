package com.grupogo.mvvmtemplateapp.ui.items;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grupogo.mvvmtemplateapp.R;
import com.grupogo.mvvmtemplateapp.model.datamodel.Item;

import java.util.List;

/**
 * Created by carlosolmedo on 17/10/17.
 */

public class ItemListAdapter extends Adapter<ItemListAdapter.ItemViewHolder>{

    private List<Item> items;
    private LayoutInflater inflater;

    public ItemListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new ItemViewHolder(inflater.inflate(R.layout.itemlist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setDataSet(List<Item> items) {
        this.items = items;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void bind(Item item) {
            textView.setText(item.getName());
        }
    }

}
