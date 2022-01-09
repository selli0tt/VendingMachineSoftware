package com.techelevator.application;

import java.math.BigDecimal;

 public class VendingMachineItems {

     protected String vendingItemName;
     protected BigDecimal vendingItemPrice;
     protected String vendingItemNumber;
     protected int vendingItemQuantity = 5;
     protected String vendingItemType;

    @Override
    public String toString() {
        return this.vendingItemNumber + ": " + this.vendingItemName + ", " + this.vendingItemPrice + " | " + this.vendingItemType + ", " + this.vendingItemQuantity + " remaining";
    }


    //Constructor
    public VendingMachineItems(String vendingItemNumber, String vendingItemName, String vendingItemPrice, String vendingItemType, int vendingItemQuantity){
        this.vendingItemNumber = vendingItemNumber;
        this.vendingItemName = vendingItemName;
        this.vendingItemPrice = new BigDecimal(vendingItemPrice);
        this.vendingItemType = vendingItemType;
        this.vendingItemQuantity = vendingItemQuantity;
    }

    //Method: calculate remaining inventory

    public void subtractOne () {
        vendingItemQuantity--;
   }


    public String getVendingItemNumber() {
        return vendingItemNumber;
    }

    public String getVendingItemName() {
        return vendingItemName;
    }

    public BigDecimal getVendingItemPrice() { return vendingItemPrice; }

    public String getVendingItemType() {return vendingItemType;}

    public int getVendingItemQuantity() { return vendingItemQuantity; }

}
