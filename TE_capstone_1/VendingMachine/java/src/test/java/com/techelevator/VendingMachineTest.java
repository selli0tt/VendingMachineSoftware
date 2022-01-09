package com.techelevator;

import com.techelevator.application.VendingMachine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine exercises;

    private File srcFile;
    private String srcContent;
    @Before
    public void set_up () throws Exception {

   srcFile = new File ("vendingmachine.csv");
       srcContent = "";
        List<String> lines = Files.readAllLines(srcFile.toPath());
        for (String line: lines) {
            srcContent += line + System.lineSeparator();
        }

    }



    }





