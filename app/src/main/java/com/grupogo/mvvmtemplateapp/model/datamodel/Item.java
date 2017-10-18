package com.grupogo.mvvmtemplateapp.model.datamodel;

/**
 * Created by carlosolmedo on 17/10/17.
 */

public class Item {

    private String text;

    public Item(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
