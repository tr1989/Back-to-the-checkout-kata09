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
        this.priceList.put("C", 20);
    }

    public int calculatePrice(List<String> itemsInCart){
        int sum = 0;
        for(int counter=0 ; counter < itemsInCart.size(); counter++) {
            String currentItem = itemsInCart.get(counter);
            sum += getPriceOfItem(currentItem);
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
