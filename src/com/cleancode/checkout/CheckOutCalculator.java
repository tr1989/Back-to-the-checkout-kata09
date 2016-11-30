package com.cleancode.checkout;

import java.util.List;

/**
 * Created by rtulya on 11/30/2016.
 */
public class CheckOutCalculator {

    public int calculatePrice(List<String> itemsInCart){
        if(itemsInCart.contains("A")){
            return 10;
        }
        return 0;
    }
}
