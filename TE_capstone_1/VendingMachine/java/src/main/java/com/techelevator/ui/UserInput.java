package com.techelevator.ui;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {

    private static Scanner scanner = new Scanner(System.in);


    public static String getHomeScreenOption() {


        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("1")) {
            return "display";
        } else if (option.equals("2")) {
            return "purchase";
        } else if (option.equals("3")) {
            return "exit";
        } else {
            return "";
        }

    }


    public static String getSecondLevelOptions () {

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");
        System.out.println();



        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("1")) {
            return "money feed";
        } else if (option.equals("2")) {
            return "purchase";
        } else if (option.equals("3")) {
            return "finish transaction";
        } else if (option.equals("4")) {
            return "Back";
        }else {
            return "";
        }
    }

    public static String getMoneyFeedOptions() { //encapsulation

        System.out.println("Please select dollar amount to add: ");
        System.out.println();
        System.out.println("1) $1.00");
        System.out.println("2) $2.00");
        System.out.println("3) $5.00");
        System.out.println("4) $10.00");
        System.out.println("5) Stop Feeding Money");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

       if (option.equals("1")) {
            return "1";
        } else if(option.equals("2")) {
           return "2";
       } else if (option.equals("3")) {
           return "5";
       }  else if (option.equals("4")) {
           return "10";
       } else if (option.equals("5")) {
           return "exit";
       }
        return "";

    }

    public static String getSelectionLevelOptions() {
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("Please enter selection: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();



        return option;
    }



}


