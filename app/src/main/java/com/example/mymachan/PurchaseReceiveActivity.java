package com.example.mymachan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import com.example.mymachan.Component.DaggerPurchaseReceiveGoodSearchComponent;
import com.example.mymachan.Component.PurchaseReceiveGoodSearchComponent;
import com.example.mymachan.base.BaseActivity;
import com.example.mymachan.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PurchaseReceiveActivity extends BaseActivity implements PurchaseReceiveGoodsContract.View{

    ActivityMainBinding activityMainBinding;

    @Inject
    PurchaseReceiveGoodsAdapter purchaseReceiveGoodsAdapter;

    @Inject
    PurchaseReceiveGoodsMaterialAdapter purchaseReceiveGoodsMaterialAdapter;

    @Inject
    PurchaseReceiveGoodSearch purchaseReceiveGoodSearch;

    @Inject
    PurchaseReceiveGoodsContract.Presenter<PurchaseReceiveGoodsContract.View> presenter;

    @Inject
    List<PurchaseReceiveGoodSearch.ItemPurchaseNumber> itemPurchaseNumbers;

    @Inject
    List<PurchaseReceiveGoodSearch.ItemMaterialNumber> itemMaterialNumbers;

    private PurchaseReceiveGoodSearchComponent purchaseReceiveGoodSearchComponent;
    private List<String> mSupplierList;
    public static final String BUNDLE_PURCHASE_RECEIVE_GOOD_SEARCH = "BUNDLE_PURCHASE_RECEIVE_GOOD_SEARCH";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        presenter.onAttached(this);
    }
    @Override
    public void init(){
        purchaseReceiveGoodSearchComponent = DaggerPurchaseReceiveGoodSearchComponent.builder()
                                        .applicationComponent(((Application)getApplication()).getApplicationComponent())
                                        .build();
        purchaseReceiveGoodSearchComponent.inject(this);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setReceiveGoodSearch(purchaseReceiveGoodSearch);
        activityMainBinding.setView(this);

        activityMainBinding.purchaseRecyclerView.setAdapter(purchaseReceiveGoodsAdapter);
        activityMainBinding.purchaseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.materialRecyclerView.setAdapter(purchaseReceiveGoodsMaterialAdapter);
        activityMainBinding.materialRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onSupplierMoreClick() {
        presenter.getSupplierList(purchaseReceiveGoodSearch.getSupplierName());
    }

    @Override
    public void onGetSupplierList(List<String> list) {
        this.mSupplierList = list;
        showItemDialog(list,onSupplierLiseDialogItemClick(list));
    }

    @Override
    public void onGetPurchaseNumberList(List<String> list, int position) {
        showItemDialog(list,onPurchaseNumberDialogItemClick(list,position));
    }

    @Override
    public void onGetMaterialNumberList(List<String> list, int position) {
        showItemDialog(list,onMaterialNumberDialogItemClick(list,position));
    }

    @Override
    public void onAddPurchaseNumberClick() {
        purchaseReceiveGoodsAdapter.addItem();
    }

    @Override
    public void onAddMaterialNumberClick() {
        purchaseReceiveGoodsMaterialAdapter.addItem();
    }

    @Override
    public void onSearchClick() {
        List<PurchaseReceiveGoodSearch.ItemPurchaseNumber> list = new ArrayList<>();
        //判斷有無混單
        for (PurchaseReceiveGoodSearch.ItemPurchaseNumber itemPurchaseNumber : purchaseReceiveGoodSearch.getPurchaseNumbersList()){
            if(!itemPurchaseNumber.getPurchaseNumber().equals("")){
                if(!itemPurchaseNumber.getPurchaseNumber().substring(1,3).
                        equals(purchaseReceiveGoodSearch.getPurchaseNumbersList().get(0).getPurchaseNumber().substring(1,3))){
                    showToast("請勿混單");
                    return;
                }
                list.add(itemPurchaseNumber);
            }
            Bundle bundle = new Bundle();
            //設定好沒混單的PurchaseNumbersList
            purchaseReceiveGoodSearch.setPurchaseNumbersList(list);
            //而物料沒有條件限制
            //這裡傳的是整個大的PurchaseReceiveGoodSearch，包含採購和物料
            bundle.putSerializable(BUNDLE_PURCHASE_RECEIVE_GOOD_SEARCH,presenter.getNoneRepeatData(purchaseReceiveGoodSearch));
            Intent intent = new Intent(PurchaseReceiveActivity.this,PurchaseReceiveGoodListActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    @Override
    public DialogInterface.OnClickListener onPurchaseNumberDialogItemClick(List<String> list, int position) {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                itemPurchaseNumbers.get(position).setPurchaseNumber(list.get(i));
                purchaseReceiveGoodsAdapter.notifyDataSetChanged();
            }
        };
    }

    @Override
    public DialogInterface.OnClickListener onMaterialNumberDialogItemClick(List<String> list, int position) {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                itemMaterialNumbers.get(position).setMaterialNumber(list.get(i));
                purchaseReceiveGoodsMaterialAdapter.notifyDataSetChanged();
            }
        };
    }

    @Override
    public DialogInterface.OnClickListener onSupplierLiseDialogItemClick(List<String> list) {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                purchaseReceiveGoodSearch.setSupplierId(mSupplierList.get(i).split(" ")[0]);
                purchaseReceiveGoodSearch.setSupplierName(mSupplierList.get(i).split(" ")[1]);
                activityMainBinding.setReceiveGoodSearch(purchaseReceiveGoodSearch);
            }
        };
    }
}