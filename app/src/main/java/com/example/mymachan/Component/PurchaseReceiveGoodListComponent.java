package com.example.mymachan.Component;

import com.example.mymachan.annotation.PurchaseReceiveGoodListScoped;
import com.example.mymachan.module.PurchaseReceiveGoodListModule;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodlist.PurchaseReceiveGoodListActivity;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodlist.PurchaseReceiveGoodListActivityContract;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveActivity;

import dagger.Component;

@PurchaseReceiveGoodListScoped
@Component(dependencies = ApplicationComponent.class,
        modules = {PurchaseReceiveGoodListModule.class}
)
public interface PurchaseReceiveGoodListComponent {
    void inject(PurchaseReceiveGoodListActivity activity);
}
