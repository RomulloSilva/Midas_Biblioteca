package com.midaslibrary.managerLibrary.model.dto.adapter;

import java.io.Serializable;

public class Data<T> implements Serializable {

    private static final long serialVersionUID = 1948048964700304027L;
    private T data;
    public Data(){}

    public Data(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
