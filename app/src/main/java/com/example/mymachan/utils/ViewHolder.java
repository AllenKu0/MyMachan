package com.example.mymachan.utils;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by 5*N on 2018/1/12
 */

public class ViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final B mViewDataBinding;

    public ViewHolder(B binding) {
        super(binding.getRoot());
        mViewDataBinding = binding;
    }

    public void bind(final Object object) {
        mViewDataBinding.setVariable(BR.data, object);
        mViewDataBinding.executePendingBindings();
    }

}