package com.grupogo.mvvmtemplateapp.data.repository;

import com.grupogo.mvvmtemplateapp.model.datamodel.Item;
import java.util.List;
import io.reactivex.Observer;

/**
 * Created by jorge_cmata on 17/10/17.
 */

public interface ItemRepository {

    void getItems(Observer<List<Item>> observer);

}
