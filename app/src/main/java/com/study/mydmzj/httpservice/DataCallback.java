package com.study.mydmzj.httpservice;

public interface DataCallback<T> {

    void success(T data);

    void failed(String result);
}
