package me.slabby.slabbot;

import java.util.ArrayList;
import java.util.HashMap;

public class Crypto {

    private ArrayList<String> cryptoList = new ArrayList<>();
    private HashMap<String, String> cryptoMap = new HashMap<>();

    public Crypto() {

    }

    public void addCrypto(String crypto) {
        cryptoList.add(crypto);
    }

    //TODO API call to get crypto data


    public String getReport() {
        String report = "";
        for (String crypto : cryptoList) {
            report += crypto + " ";
        }
        return report;
    }

}
