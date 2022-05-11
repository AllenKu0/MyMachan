package com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PurchaseReceiveGoodSearch implements Serializable {

    private String supplierName = "";
    private String supplierId = "";
    private List<ItemMaterialNumber> materialNumberList = new ArrayList<>();
    private List<ItemPurchaseNumber> purchaseNumbersList = new ArrayList<>();
    private List<String> purchaseNumber = new ArrayList<>();
    private List<String> materialNumber = new ArrayList<>();

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public List<ItemMaterialNumber> getMaterialNumberList() {
        return materialNumberList;
    }

    public void setMaterialNumberList(List<ItemMaterialNumber> materialNumberList) {
        this.materialNumberList = materialNumberList;
    }

    public List<ItemPurchaseNumber> getPurchaseNumbersList() {
        return purchaseNumbersList;
    }

    public void setPurchaseNumbersList(List<ItemPurchaseNumber> purchaseNumbersList) {
        this.purchaseNumbersList = purchaseNumbersList;
    }

    public List<String> getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(List<String> purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public List<String> getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(List<String> materialNumber) {
        this.materialNumber = materialNumber;
    }

    public static class ItemPurchaseNumber implements Serializable{
        private String purchaseNumber = "";
        private int position = 0;

        public String getPurchaseNumber() {
            return purchaseNumber;
        }

        public void setPurchaseNumber(String purchaseNumber) {
            this.purchaseNumber = purchaseNumber;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public static class ItemMaterialNumber implements Serializable{
        private String materialNumber = "";
        private int position = 0;

        public String getMaterialNumber() {
            return materialNumber;
        }

        public void setMaterialNumber(String materialNumber) {
            this.materialNumber = materialNumber;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
