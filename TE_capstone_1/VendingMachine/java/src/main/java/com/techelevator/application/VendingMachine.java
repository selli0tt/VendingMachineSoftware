package com.techelevator.application;

import com.techelevator.VendingMachineCLI;
import com.techelevator.ui.*;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private List<VendingMachineItems> vendingItems = new ArrayList<>();
    private List<String> logList = new ArrayList<>();
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
    String fDTime = now.format(format);

    private BigDecimal balance = new BigDecimal("0");
    private BigDecimal currentBalance = new BigDecimal("0");


    public void fileWriter() {

        try {
            FileWriter writer = new FileWriter("log.txt", true);

            for (String str : logList) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public String readFile() {
        //Read through text
        File vendingFile = new File("vendingmachine.csv");

        //Generate and hold list of vending items


            try {
                //parsing text data into readable data types through a delimiter pattern
                Scanner fileScanner = new Scanner(vendingFile);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine(); //reads each line in the file and continues down until end
                    //split line into array of strings
                    String[] lineArr = line.split("\\|");

                    String itemNumber = lineArr[0];
                    String items = lineArr[1];
                    String price = lineArr[2];
                    String itemType = lineArr[3];
                    int quantity = Integer.parseInt(lineArr[4]);

                    VendingMachineItems vendingItem = new VendingMachineItems(itemNumber, items, price, itemType, quantity);
                    vendingItems.add(vendingItem);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return "";

        }



    public String run() {
        readFile();
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                listProducts();
            } else if (choice.equals("purchase")) {
                purchaseLevelTwo();
            } else if (choice.equals("exit")) {
                System.exit(0);
            }
        }
    }


    public String purchaseLevelTwo() {

        boolean stay = true;

        do {
            System.out.println("Current Money Provided: $" + this.balance);
            String choice = UserInput.getSecondLevelOptions();

            if (choice.equals("money feed")) {
                moneyFeedTwo();
            } else if (choice.equals("purchase")) {
                selectionLevelTwo();
            } else if (choice.equals("finish transaction")) {
                logList.add(">" + fDTime + " GIVE CHANGE: \\$" + this.balance + " \\$" + this.balance.subtract(this.balance));
                logList.add(">\\ \\ \\");
                fileWriter();
                finishLevelTwo();
            } else if (choice.equals("Back")) {
                UserOutput.displayHomeScreen();
            }

        } while (stay);
        return "";

    }

    public String moneyFeedTwo() {

        boolean stay = true;


        do {
            String choice = UserInput.getMoneyFeedOptions();


            if (choice.equals("1")) {
                this.balance = this.balance.add(new BigDecimal("1.00"));

            } else if (choice.equals("2")) {
                this.balance = this.balance.add(new BigDecimal("2.00"));

            } else if (choice.equals("5")) {
                this.balance = this.balance.add(new BigDecimal("5.00"));

            } else if (choice.equals("10")) {
                this.balance = this.balance.add(new BigDecimal("10.00"));

            } else if (choice.equals("exit")) {

                stay = false;
            }

            System.out.println("Current Money Provided: $" + this.balance + " ");

            if (!choice.equals("exit")) {
                logList.add(">" + fDTime + " FEED MONEY: \\$" + choice + ".00 \\$" + this.balance);

            }

        } while (stay);

        return "";
    }

    public void listProducts() {
        for (VendingMachineItems vendingItem : vendingItems) {
            System.out.println(vendingItem);
        }
    }

    public String selectionLevelTwo() {

        System.out.println("***************************************************");
        System.out.println("***************************************************");

        this.listProducts();

        boolean stay = true;
        do {
            String choice = UserInput.getSelectionLevelOptions();
            boolean found = false;


            for (VendingMachineItems vendingItem : vendingItems) {

                if (choice.equals(vendingItem.getVendingItemNumber())) {
                    System.out.println(vendingItem.getVendingItemName());

                    String desiredItemNumber = vendingItem.getVendingItemNumber().toUpperCase();

                    found = true;

                    if (this.balance.compareTo(vendingItem.getVendingItemPrice()) == 0 || this.balance.compareTo(vendingItem.getVendingItemPrice()) == 1) {

                        if (vendingItem.getVendingItemQuantity() > 0) {

                            this.currentBalance = this.balance;
                            this.balance = this.balance.subtract((vendingItem.getVendingItemPrice()));
                            vendingItem.subtractOne();
                            System.out.println("Current Balance : $" + this.balance);

                            if (choice.equals(desiredItemNumber)) {
                                logList.add(">" + fDTime + " " + vendingItem.getVendingItemName() + " " + desiredItemNumber + " \\$" + this.currentBalance + " \\$" + this.balance);
                            }

                            if (vendingItem.getVendingItemType().equals("Chip")) {
                                System.out.println("Crunch Crunch, Yum!");
                                purchaseLevelTwo();
                            } else if (vendingItem.getVendingItemType().equals("Candy")) {
                                System.out.println("Munch Munch, Yum!");
                                purchaseLevelTwo();
                            } else if (vendingItem.getVendingItemType().equals("Drink")) {
                                System.out.println("Glug Glug, Yum!");
                                purchaseLevelTwo();
                            } else {
                                System.out.println("Chew Chew, Yum!");
                                purchaseLevelTwo();
                            }
                        } else {
                            System.out.println("SOLD OUT");
                            System.out.println("Current Balance : $" + this.balance);
                            purchaseLevelTwo();
                        }

                    } else {
                        System.out.println("Insufficient Funds");
                        purchaseLevelTwo();
                    }
                }

            }
            if (!found) {
                System.out.println("Item Does Not Exist");
            }


        } while (stay);
        return "";
    }

    public String finishLevelTwo() {

        UserOutput.displayFinishScreen();


        BigDecimal conversionFactor = new BigDecimal("100");

        BigDecimal change = this.balance.multiply(conversionFactor);

        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickel = new BigDecimal("5");

//Goal Is to give you back smallest amount of coinage possible

        BigDecimal quarters = change.divide(quarter); //to see max amount quarters you'd get back
        change = change.remainder(quarter); // modulo to get remaining change
        BigDecimal dimes = change.divide(dime);
        change = change.remainder(dime);
        BigDecimal nickels = change.divide(nickel);
        change = change.remainder(nickel);


        System.out.println(quarters.setScale(0, RoundingMode.DOWN)
                + " quarters");
        System.out.println(dimes.setScale(0, RoundingMode.DOWN)
                + " dimes");
        System.out.println(nickels.setScale(0, RoundingMode.DOWN)
                + " nickels and");



        this.balance = change.subtract(change);

        System.out.println("Current Balance: $" + this.balance);


        run();

        return "";
    }


}




