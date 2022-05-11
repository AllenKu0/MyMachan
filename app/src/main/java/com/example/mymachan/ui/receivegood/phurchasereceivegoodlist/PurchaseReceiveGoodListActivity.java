package com.example.mymachan.ui.receivegood.phurchasereceivegoodlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.mymachan.Application;
import com.example.mymachan.Component.DaggerPurchaseReceiveGoodListComponent;
import com.example.mymachan.Component.PurchaseReceiveGoodListComponent;
import com.example.mymachan.R;
import com.example.mymachan.base.BaseActivity;
import com.example.mymachan.databinding.ActivityPurchaseReceiveGoodListBinding;
import com.example.mymachan.module.PurchaseReceiveGoodListModule;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveActivity;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearch;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodResponse;
import com.example.mymachan.utils.sharepreference.LoginPreferencesProvider;

import java.util.List;

import javax.inject.Inject;

public class PurchaseReceiveGoodListActivity extends BaseActivity
        implements PurchaseReceiveGoodListActivityContract.View {

    @Inject
    LoginPreferencesProvider loginPreferencesProvider;

    @Inject
    PurchaseReceiveGoodListActivityContract.Presenter<PurchaseReceiveGoodListActivityContract.View> presenter;

    @Inject
    PurchaseReceiveGoodListAdapter purchaseReceiveGoodListAdapter;

    private PurchaseReceiveGoodSearch purchaseReceiveGoodSearch;
    private ActivityPurchaseReceiveGoodListBinding purchaseReceiveGoodListBinding;
    private PurchaseReceiveGoodListComponent purchaseReceiveGoodListComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_receive_good_list);
        init();

        presenter.onAttached(this);
        presenter.getReceiveGoodList(purchaseReceiveGoodSearch);

    }

    @Override
    public void init() {
        purchaseReceiveGoodListComponent = DaggerPurchaseReceiveGoodListComponent.builder()
                                    .applicationComponent(((Application)(getApplicationContext())).getApplicationComponent())
                                    .purchaseReceiveGoodListModule(new PurchaseReceiveGoodListModule(this))
                                    .build();
        purchaseReceiveGoodListComponent.inject(this);
        purchaseReceiveGoodListBinding = DataBindingUtil.setContentView(this,R.layout.activity_purchase_receive_good_list);
        purchaseReceiveGoodListBinding.setView(this);
        purchaseReceiveGoodListBinding.setCount(getResourceString(R.string.hint_zero));
        purchaseReceiveGoodSearch = (PurchaseReceiveGoodSearch) getIntent().getExtras().getSerializable(PurchaseReceiveActivity.BUNDLE_PURCHASE_RECEIVE_GOOD_SEARCH);
        Log.e("TAG", "init: aaaaaaaaa" + purchaseReceiveGoodSearch );
        purchaseReceiveGoodListBinding.setSupplier(purchaseReceiveGoodSearch.getSupplierName());
        purchaseReceiveGoodListBinding.purchaseReceiveGoodListRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        purchaseReceiveGoodListBinding.purchaseReceiveGoodListRecyclerview.setAdapter(purchaseReceiveGoodListAdapter);
    }

    @Override
    public void onSubmitClick() {

    }

    @Override
    public void onBackClick() {

    }

    @Override
    public void onReceiveGoodResponse(List<ReceiveGoodResponse> list) {
        purchaseReceiveGoodListBinding.setCount(String.valueOf(list.size()));
        purchaseReceiveGoodListAdapter.setListData(list);
    }
}