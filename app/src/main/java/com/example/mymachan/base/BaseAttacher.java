package com.example.mymachan.base;

public interface BaseAttacher <V extends BaseView>{
    void onAttached(V view);

    void onDetached();
}
