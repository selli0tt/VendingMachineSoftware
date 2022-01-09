package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineItemsTest {

    @Test
    public void vending_machine_items_test(){
        VendingMachineItems newItem = new VendingMachineItems( "A1", "Nachos", "1.25", "Chips", 5);

        assertEquals("Nachos", newItem.getVendingItemName());
        assertEquals(new BigDecimal("1.25"), newItem.getVendingItemPrice());
        assertEquals("A1", newItem.getVendingItemNumber());
        assertEquals("Chips", newItem.getVendingItemType());
        assertEquals(5, newItem.getVendingItemQuantity());
    }




}