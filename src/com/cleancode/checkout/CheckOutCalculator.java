package com.cleancode.checkout;

import java.util.*;

/**
 * Created by rtulya on 11/30/2016.
 */
public class CheckOutCalculator {

    private Map<String, Integer> priceList = new HashMap<String, Integer>();
    private Map<String, HashMap<Integer, Integer>> specialOfferPriceList = new HashMap<String, HashMap<Integer, Integer>>();

    public CheckOutCalculator() {
        this.priceList.put("A", 10);
        this.priceList.put("B", 15);
        this.priceList.put("C", 20);
        HashMap<Integer, Integer> specialPrice = new HashMap<Integer, Integer>();
        specialPrice.put(3,25);
        this.specialOfferPriceList.put("A", specialPrice);
        HashMap<Integer, Integer> specialPrice2 = new HashMap<Integer, Integer>();
        specialPrice2.put(2,25);
        this.specialOfferPriceList.put("B", specialPrice2);
    }

    public int calculatePrice(List<String> itemsInCart){
        int sum = 0;
        HashMap<String, Integer> itemOccurance = new HashMap<String, Integer>();
        for(int counter=0 ; counter < itemsInCart.size(); counter++) {
            String currentItem = itemsInCart.get(counter);
            if(itemOccurance.containsKey(currentItem)){
                itemOccurance.put(currentItem, itemOccurance.get(currentItem)+1);
            }else {
                itemOccurance.put(currentItem, 1);
            }
        }
        for (String currentItem : itemOccurance.keySet()) {
            if(specialOfferPriceList.containsKey(currentItem) &&
                    isSpecialPrizeApplicable(currentItem, itemOccurance)){
                    sum += getSpecialPriceOfItem(currentItem, itemOccurance);
            }else{
                sum += getPriceOfItem(currentItem)*itemOccurance.get(currentItem);
            }
        }
        return sum;
    }

    protected int getPriceOfItem(String itemName){
        if(priceList.containsKey(itemName)) {
            return priceList.get(itemName);
        }
        return 0;
    }

    protected boolean isSpecialPrizeApplicable(String itemName, HashMap<String, Integer> itemOccurance){
        HashMap<Integer,Integer> specailOfferForCurrentItem = specialOfferPriceList.get(itemName);
        boolean flag = false;
        if(specailOfferForCurrentItem != null) {
            for (int specialOfferOnItemCount : specailOfferForCurrentItem.keySet()) {
                if (itemOccurance.get(itemName) >= specialOfferOnItemCount) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    protected int getSpecialPriceOfItem(String itemName, HashMap<String, Integer> itemOccurance){
        HashMap<Integer,Integer> specailOfferForCurrentItem = specialOfferPriceList.get(itemName);
        boolean flag = false;
        int price = 0;
        int remainingcount = itemOccurance.get(itemName);
        for (int specialOfferOnItemCount  : specailOfferForCurrentItem.keySet()) {
            if(remainingcount >= specialOfferOnItemCount){
                flag = true;
                price = specailOfferForCurrentItem.get(specialOfferOnItemCount);
                remainingcount = remainingcount - specialOfferOnItemCount;
                break;
            }
        }
        if(remainingcount > 0){
            int remainPrice =  getPriceOfItem(itemName)*remainingcount;
            return price+remainPrice;
        }else{
            return price;
        }
    }
}
