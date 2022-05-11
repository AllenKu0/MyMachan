package com.example.mymachan.ui.receivegood.phurchasereceivegoodlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymachan.R;
import com.example.mymachan.databinding.ItemPurchaseReceiveGoodListBinding;
import com.example.mymachan.utils.ViewHolder;
import com.example.mymachan.utils.api.pojo.createreceivingorderbysingle.CreateReceivingOrderBySingleRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

public class PurchaseReceiveGoodListAdapter extends RecyclerView.Adapter<ViewHolder<ItemPurchaseReceiveGoodListBinding>>
        implements PurchaseReceiveGoodListActivityContract.Adapter{

    @Inject
    AppCompatActivity activity;


    private List<ReceiveGoodResponse> mDataList;
    private List<CreateReceivingOrderBySingleRequest> mSubmitList;
    private List<ReceiveGoodResponse> tagList = new ArrayList<>();
    private ItemPurchaseReceiveGoodListBinding itemPurchaseReceiveGoodListBinding;

    private String splitFromBillDate="";
    private String billDate="";
    private String year="",month="",date="";

    @Inject
    public PurchaseReceiveGoodListAdapter(){

    }
    @Override
    public void onItemClick(int position) {
        Log.e("TAG", "onItemClick: kkkkkkkkkk" );
        mDataList.get(position).setChecked(!mDataList.get(position).isChecked());
        notifyDataSetChanged();
    }

    @Override
    public void onMoreClick(int position) {
        for(int i=0,l=mDataList.size();i<l;i++){
            mDataList.get(i).setOpen(false);
        }
        mDataList.get(position).setOpen(true);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder<ItemPurchaseReceiveGoodListBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        itemPurchaseReceiveGoodListBinding = ItemPurchaseReceiveGoodListBinding.inflate(layoutInflater,parent,false);
        itemPurchaseReceiveGoodListBinding.setView(this);
        itemPurchaseReceiveGoodListBinding.setActivity(activity);
        return new ViewHolder<>(itemPurchaseReceiveGoodListBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder<ItemPurchaseReceiveGoodListBinding> holder, int position) {
        final ReceiveGoodResponse getPurOrderByBParIdResponse = mDataList.get(position);
        if(getPurOrderByBParIdResponse.getDeliverDate().length()!=0){
            billDate = getPurOrderByBParIdResponse.getDeliverDate();
            splitFromBillDate = billDate.substring(0,4)+"-"+billDate.substring(4,6)+"-"+billDate.substring(6,billDate.length());
            getPurOrderByBParIdResponse.setSplitFromBillDate(splitFromBillDate);
        }
        itemPurchaseReceiveGoodListBinding.setData(getPurOrderByBParIdResponse);
        itemPurchaseReceiveGoodListBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataList == null ?0:mDataList.size();
    }
    @Override
    public void setListData(List<ReceiveGoodResponse> list) {
        for (int i=0;i<list.size();i++){
            list.get(i).setPosition(i);
            if(list.get(i).getDivider().isEmpty()){
                Log.e("TAG", "setListData: aaaaaaa");
                initSubmitData(list);
            }else{
                Log.e("TAG", "setListData: bbbbbbb");
                calculatedItems(mDataList);
            }
        }
        mDataList = list;

        notifyDataSetChanged();
    }

    @Override
    public void initSubmitData(List<ReceiveGoodResponse> list) {
        mSubmitList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CreateReceivingOrderBySingleRequest createReceivingOrderBySingleRequest = new CreateReceivingOrderBySingleRequest();
            createReceivingOrderBySingleRequest.setFromOrderBillNo(list.get(i).getBillNo());
            createReceivingOrderBySingleRequest.setFromOrderRowId(list.get(i).getRowId());

            createReceivingOrderBySingleRequest.setReceivingSQty(list.get(i).getUnTransSQty());

            Log.v("hi", "1111");

            if (list.get(i).getBillNo().contains("SB")) {
                createReceivingOrderBySingleRequest.setDestTypeId("SB10");
            } else {
                createReceivingOrderBySingleRequest.setDestTypeId("RC10");
            }
            mSubmitList.add(createReceivingOrderBySingleRequest);
        }
    }



    private void calculatedItems(List<ReceiveGoodResponse> mList) {
        mSubmitList = new ArrayList<>();
        tagList.clear();
        CreateReceivingOrderBySingleRequest createReceivingOrderBySingleRequest=new CreateReceivingOrderBySingleRequest();
        for (ReceiveGoodResponse item : mList) {
            Log.v("mList", String.valueOf(mList.size()));
            if (item.getDivider().isEmpty()) {
                //item.setUnTransSQty(item.getUnTransSQty());
                Log.v("item",item.getUnTransSQty());
                if (item.getBillNo().contains("SB")) {
                    createReceivingOrderBySingleRequest.setDestTypeId("SB10");
                } else {
                    createReceivingOrderBySingleRequest.setDestTypeId("RC10");
                }
                mSubmitList.add(createReceivingOrderBySingleRequest);
                tagList.add(getmData(item, Integer.parseInt(item.getUnTransSQty())));
                continue;
            }
            int divider = (int) (float) Float.valueOf(item.getDivider());
            int quantity = (int) (float) Float.valueOf(item.getUnTransSQty());
            Log.v("12457",item.getDivider());
            if (divider > quantity) {
                divider = quantity;
            }

            int value = quantity / divider;
            int remain = quantity % divider;

            for (int i = 0; i < value; i++) {
                boolean sb = false;
                if (item.getBillNo().contains("SB")) {
                    sb = true;
                }
                tagList.add(getmData(item, divider));
                mSubmitList.add(getNewItem(item, divider, sb));
                Log.v("calsqt",tagList.get(i).getUnTransSQty());
            }
            if (remain > 0) {
                boolean sb = false;
                if (item.getBillNo().contains("SB")) {
                    sb = true;
                }
                tagList.add(getmData(item, remain));
                mSubmitList.add(getNewItem(item, remain, sb));
                Log.v("calsqt",tagList.get(0).getUnTransSQty());
            }
        }
        //Float to float to int
    }
    private ReceiveGoodResponse getmData(ReceiveGoodResponse item, int divider) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = sDateFormat.format(new java.util.Date());
        ReceiveGoodResponse receiveGoodResponse=new ReceiveGoodResponse();
        receiveGoodResponse.setCheckType(item.getCheckType());
        receiveGoodResponse.setReciveDate(date);
        receiveGoodResponse.setMaterialId(item.getMaterialId());
        receiveGoodResponse.setMaterialName(item.getMaterialName());
        receiveGoodResponse.setStorage(item.getStorage());
        receiveGoodResponse.setBillDate(item.getBillDate());
        receiveGoodResponse.setBizPartnerId(item.getBizPartnerId());
        receiveGoodResponse.setUnTransSQty(String.valueOf(divider));
        receiveGoodResponse.setCUBillNo(item.getCUBillNo());
        receiveGoodResponse.setSQuantity(item.getSQuantity());
        receiveGoodResponse.setPosition(item.getPosition());
        receiveGoodResponse.setBillNo(item.getBillNo());
        receiveGoodResponse.setOrgId(item.getOrgId());
        receiveGoodResponse.setRowId(item.getRowId());
        receiveGoodResponse.setShortName(item.getShortName());
        receiveGoodResponse.setBadnessSQty(item.getBadnessSQty());
        receiveGoodResponse.setGradeSQty(item.getGradeSQty());
        return receiveGoodResponse;
    }

    private CreateReceivingOrderBySingleRequest getNewItem(ReceiveGoodResponse item, int divider,boolean sb) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = sDateFormat.format(new java.util.Date());
        Log.d("calculatedItems132", String.valueOf(divider));

        CreateReceivingOrderBySingleRequest receivingOrderBySingleRequest=new CreateReceivingOrderBySingleRequest();
        receivingOrderBySingleRequest.setReceivingSQty(String.valueOf(divider));
        receivingOrderBySingleRequest.setStorage(item.getStorage());
        receivingOrderBySingleRequest.setBillDate(date);
        receivingOrderBySingleRequest.setReciveDate(date);
        Log.d("calculatedItems132", String.valueOf(sb));

        if (sb){
            receivingOrderBySingleRequest.setDestTypeId("SB10");
        } else {
            receivingOrderBySingleRequest.setDestTypeId("RC10");
        }
        return receivingOrderBySingleRequest;
    }
}
