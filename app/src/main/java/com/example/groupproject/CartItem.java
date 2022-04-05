package com.example.groupproject;

import java.util.ArrayList;
import java.util.List;

public class CartItem {
    private List<String> itemName;
    private List<String> itemQuantity;
    private List<String> itemPrice;

    public CartItem(){
        itemName = new ArrayList<String>();
        itemQuantity = new ArrayList<String>();
        itemPrice = new ArrayList<String>();
    }

    public CartItem(String itemName, String itemQuantity, String itemPrice) {
//        this.itemName = itemName;
//        this.itemQuantity = itemQuantity;
//        this.itemPrice = itemPrice;
    }

    public List<String> getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.add(itemName);
    }

    public List<String> getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity.add(itemQuantity);
    }

    public List<String> getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice.add(itemPrice);
    }

    public int getSize(){
        return itemName.size();
    }

    public void restoreItemList(List<String> itemNames, List<String> itemQuan, List<String> itemPrice)
    {
        this.itemName = itemNames;
        this.itemQuantity = itemQuan;
        this.itemPrice = itemPrice;
    }

    public void clearCart(List<String> itemNames, List<String> itemQuan, List<String> itemPrice){
//        itemNames.clear();
//        itemQuan.clear();
//        itemPrice.clear();
    }
}
