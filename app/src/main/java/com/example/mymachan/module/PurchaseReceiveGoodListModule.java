package com.example.mymachan.module;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymachan.annotation.PurchaseReceiveGoodListScoped;
import com.example.mymachan.annotation.PurchaseReceiveGoodSearchScoped;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodlist.PurchaseReceiveGoodListActivityContract;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodlist.PurchaseReceiveGoodListAdapter;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodlist.PurchaseReceiveGoodListPresenter;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearchPresenter;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodsContract;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodDeliveryRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class PurchaseReceiveGoodListModule {
    private AppCompatActivity activity;

    public PurchaseReceiveGoodListModule(AppCompatActivity activity){
        this.activity =activity;
    }
    @Provides
    @PurchaseReceiveGoodListScoped
    AppCompatActivity provideActivity(){
        return activity;
    }
    @Provides
    @PurchaseReceiveGoodListScoped
    ReceiveGoodDeliveryRequest provideReceiveGoodDeliveryRequest(){
        return new ReceiveGoodDeliveryRequest();
    }

    @Provides
    @PurchaseReceiveGoodListScoped
    PurchaseReceiveGoodListActivityContract.Presenter<PurchaseReceiveGoodListActivityContract.View> providePresenter
            (PurchaseReceiveGoodListPresenter<PurchaseReceiveGoodListActivityContract.View> presenter){
        return presenter;
    }

    @Provides
    @PurchaseReceiveGoodListScoped
    PurchaseReceiveGoodListActivityContract.Adapter provideAdapter(PurchaseReceiveGoodListAdapter adapter){
        return adapter;
    }

    @Provides
    @PurchaseReceiveGoodListScoped
    ReceiveGoodRequest provideReceiveGood(){
        return new ReceiveGoodRequest();
    }

    @Provides
    @PurchaseReceiveGoodListScoped
    @Named("BatchList")
    List<ReceiveGoodResponse> provideReceiveGoodResponseBatchList() {
        return new ArrayList<>();
    }
}
