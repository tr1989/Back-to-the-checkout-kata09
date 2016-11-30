package com.cleancode.checkout;

import java.util.*;

/**
 * Created by rtulya on 11/30/2016.
 */
public class CheckOutCalculator {

    private Map<String, Integer> priceList = new HashMap<String, Integer>();

    public CheckOutCalculator() {
        this.priceList.put("A", 10);
        this.priceList.put("B", 15);
    }

    public int calculatePrice(List<String> itemsInCart){
        int sum = 0;
        if(itemsInCart.contains("A")){
            sum += getPriceOfItem("A");
        } if (itemsInCart.contains("B")){
            sum += getPriceOfItem("B");
        }else {
            sum += getPriceOfItem("");
        }
        return sum;
    }

    protected int getPriceOfItem(String itemName){
        if(priceList.containsKey(itemName)) {
            return priceList.get(itemName);
        }
        return 0;
    }
}
