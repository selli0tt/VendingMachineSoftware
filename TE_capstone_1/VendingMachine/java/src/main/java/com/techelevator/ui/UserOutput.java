package com.techelevator.ui;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayMoneyFeedScreen()
    {
        System.out.println("Enter dollar amount: ");
        System.out.println();
        System.out.println();
        System.out.println("Press b to exit");
        System.out.println();


    }

    public static void displayProductSelectionScreen()
    {
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("Please enter selection: ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Current Money Provided: $$$");
    }

    public static void displayFinishScreen()
    {

        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("Change Due: ");


    }

    public static void displayPurchaseLevelTwoScreen()
    {
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("Please enter selection: ");
        System.out.println();
        System.out.println();
        System.out.println();

    }

}
