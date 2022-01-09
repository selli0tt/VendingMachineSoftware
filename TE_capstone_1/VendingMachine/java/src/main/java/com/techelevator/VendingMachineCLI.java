package com.techelevator;

import com.techelevator.application.VendingMachine;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;


public class VendingMachineCLI {

    public static void main(String[] args){

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();
    }





}

