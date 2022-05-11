package com.example.mymachan.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearch;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearchPresenter;
import com.example.mymachan.annotation.PurchaseReceiveGoodSearchScoped;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodsAdapter;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodsContract;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodRequest;

import java.util.List;

import dagger.Module;
import dagger.Provides;
@Module
public abstract class PurchaseReceiveGoodSearchModel {
    @Provides
    @PurchaseReceiveGoodSearchScoped
    static AppCompatActivity provideActivity() {
        return new AppCompatActivity();
    }

    @Provides
    @PurchaseReceiveGoodSearchScoped
    static Context provideContext() {
        return new AppCompatActivity();
    }

    @Provides
    @PurchaseReceiveGoodSearchScoped
    static PurchaseReceiveGoodsContract.Presenter<PurchaseReceiveGoodsContract.View> providePresenter(
            PurchaseReceiveGoodSearchPresenter<PurchaseReceiveGoodsContract.View> presenter) {
        return presenter;
    }

    @Provides
    @PurchaseReceiveGoodSearchScoped
    static PurchaseReceiveGoodsContract.Adapter provideAdapter(PurchaseReceiveGoodsAdapter adapter) {
        return adapter;
    }

    @Provides
    @PurchaseReceiveGoodSearchScoped
    static PurchaseReceiveGoodSearch provideReceiveGoodSearch() {
        return new PurchaseReceiveGoodSearch();
    }


    @Provides
    @PurchaseReceiveGoodSearchScoped
    static List<PurchaseReceiveGoodSearch.ItemPurchaseNumber> provideItemPurchaseNumbers(PurchaseReceiveGoodSearch receiveGoodSearch) {
        return receiveGoodSearch.getPurchaseNumbersList();
    }

    @Provides
    @PurchaseReceiveGoodSearchScoped
    static List<PurchaseReceiveGoodSearch.ItemMaterialNumber> provideItemMaterialNumbers(PurchaseReceiveGoodSearch receiveGoodSearch) {
        return receiveGoodSearch.getMaterialNumberList();

    }
    @Provides
    @PurchaseReceiveGoodSearchScoped
    static ReceiveGoodRequest provideReceiveGoodRequest(){
        return new ReceiveGoodRequest();
    }
}
