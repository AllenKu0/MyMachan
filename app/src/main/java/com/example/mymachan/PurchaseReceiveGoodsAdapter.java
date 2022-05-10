package com.example.mymachan;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymachan.databinding.ItemPurchaseReceiveGoodBinding;
import com.example.mymachan.utils.ViewHolder;

import java.util.List;

import javax.inject.Inject;

public class PurchaseReceiveGoodsAdapter extends RecyclerView.Adapter<ViewHolder<ItemPurchaseReceiveGoodBinding>>
        implements PurchaseReceiveGoodsContract.Adapter{

    private ItemPurchaseReceiveGoodBinding itemPurchaseReceiveGoodBinding;

    @Inject
    List<PurchaseReceiveGoodSearch.ItemPurchaseNumber> mDataList;

    @Inject
    PurchaseReceiveGoodsContract.Presenter<PurchaseReceiveGoodsContract.View> presenter;

    @Inject
    PurchaseReceiveGoodSearch purchaseReceiveGoodSearch;
    @Inject
    public PurchaseReceiveGoodsAdapter() {

    }

    @Override
    public void addItem() {
        mDataList.add(new PurchaseReceiveGoodSearch.ItemPurchaseNumber());
        notifyDataSetChanged();
    }

    @Override
    public void onMoreClick(int position) {
        Log.e("TAG", "onMoreClick: rrrrrrr" );
        //有無選廠商
        if(purchaseReceiveGoodSearch.getSupplierId().isEmpty()){
            Log.e("TAG", "onMoreClick: aaaaaa" );
            presenter.showSelectProvideToast();
        }else{
            Log.e("TAG", "onMoreClick: bbbbbb" );
            presenter.getPurchaseNumberList(purchaseReceiveGoodSearch.getSupplierId(),position);
        }

    }


    @NonNull
    @Override
    public ViewHolder<ItemPurchaseReceiveGoodBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e("TAG", "onCreateViewHolder: akakak" );
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        itemPurchaseReceiveGoodBinding = ItemPurchaseReceiveGoodBinding.inflate(inflater,parent,false);
        itemPurchaseReceiveGoodBinding.setView(this);

        return new ViewHolder<>(itemPurchaseReceiveGoodBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder<ItemPurchaseReceiveGoodBinding> holder, int position) {
        PurchaseReceiveGoodSearch.ItemPurchaseNumber item = mDataList.get(position);
        itemPurchaseReceiveGoodBinding.setData(item);
        itemPurchaseReceiveGoodBinding.executePendingBindings();
        mDataList.get(position).setPosition(position);
//        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mDataList == null? 0 : mDataList.size();
    }
}
