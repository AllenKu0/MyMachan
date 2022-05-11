package com.example.mymachan.Component;

import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveActivity;
import com.example.mymachan.annotation.PurchaseReceiveGoodSearchScoped;
import com.example.mymachan.module.PurchaseReceiveGoodSearchModel;

import dagger.Component;

@PurchaseReceiveGoodSearchScoped
@Component(
        dependencies = ApplicationComponent.class,
        modules = PurchaseReceiveGoodSearchModel.class
)
public interface PurchaseReceiveGoodSearchComponent {
    void inject(PurchaseReceiveActivity activity);
}
