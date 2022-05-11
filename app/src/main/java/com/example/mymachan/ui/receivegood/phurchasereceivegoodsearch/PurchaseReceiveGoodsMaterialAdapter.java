package com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymachan.databinding.ItemPurchaseReceiveGoodMaterialBinding;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearch;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodsContract;
import com.example.mymachan.utils.ViewHolder;

import java.util.List;

import javax.inject.Inject;

public class PurchaseReceiveGoodsMaterialAdapter extends RecyclerView.Adapter<ViewHolder<ItemPurchaseReceiveGoodMaterialBinding>>
        implements PurchaseReceiveGoodsContract.Adapter{

    private ItemPurchaseReceiveGoodMaterialBinding itemPurchaseReceiveGoodMaterialBinding;

    @Inject
    List<PurchaseReceiveGoodSearch.ItemMaterialNumber> mDataList;

    @Inject
    PurchaseReceiveGoodsContract.Presenter<PurchaseReceiveGoodsContract.View> presenter;

    @Inject
    PurchaseReceiveGoodSearch purchaseReceiveGoodSearch;
    @Inject
    public PurchaseReceiveGoodsMaterialAdapter() {

    }

    @Override
    public void addItem() {
        mDataList.add(new PurchaseReceiveGoodSearch.ItemMaterialNumber());
        notifyDataSetChanged();
    }

    @Override
    public void onMoreClick(int position) {
        if(purchaseReceiveGoodSearch.getSupplierId().isEmpty()){
            presenter.showSelectProvideToast();
        }else{
            presenter.getMaterialNumberList(purchaseReceiveGoodSearch.getSupplierId(),position);
        }

    }


    @NonNull
    @Override
    public ViewHolder<ItemPurchaseReceiveGoodMaterialBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        itemPurchaseReceiveGoodMaterialBinding = ItemPurchaseReceiveGoodMaterialBinding.inflate(inflater,parent,false);
        itemPurchaseReceiveGoodMaterialBinding.setView(this);
        return new ViewHolder<>(itemPurchaseReceiveGoodMaterialBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder<ItemPurchaseReceiveGoodMaterialBinding> holder, int position) {
        PurchaseReceiveGoodSearch.ItemMaterialNumber item = mDataList.get(position);
        mDataList.get(position).setPosition(position);
        itemPurchaseReceiveGoodMaterialBinding.setData(item);
        itemPurchaseReceiveGoodMaterialBinding.executePendingBindings();
//        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mDataList == null? 0 : mDataList.size();
    }
}
