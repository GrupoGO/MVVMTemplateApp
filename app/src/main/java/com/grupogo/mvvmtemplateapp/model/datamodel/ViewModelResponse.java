package com.grupogo.mvvmtemplateapp.model.datamodel;

/**
 * Created by jorge_cmata on 18/10/17.
 */

public class ViewModelResponse<T> {

    private T data;
    private Throwable error;

    public ViewModelResponse(T data) {
        this.data = data;
    }

    public ViewModelResponse(Throwable error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }
}
