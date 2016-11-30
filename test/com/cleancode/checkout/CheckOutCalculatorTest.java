package com.cleancode.checkout;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rtulya on 11/30/2016.
 */
public class CheckOutCalculatorTest {
    @Test
    public void test_zero_item_in_cart() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList();
        Assert.assertEquals(0, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_an_item_A_in_cart() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("A");
        Assert.assertEquals(10, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_an_item_B_in_cart() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("B");
        Assert.assertEquals(15, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_multiple_items_A_and_B_in_cart() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("A","B");
        Assert.assertEquals(25, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_multiple_items_A_B_and_C_in_cart() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("A","B", "C");
        Assert.assertEquals(45, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_more_than_one_item_A_in_cart() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("A","A");
        Assert.assertEquals(20, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_3_A_in_cart_and_specail_offer_on_3_A() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("A","A","A");
        Assert.assertEquals(25, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_2_B_in_cart_and_specail_offer_on_2_B() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("B","B");
        Assert.assertEquals(35, checkOutCalculator.calculatePrice(itemsInCart));
    }

    @Test
    public void test_3_B_in_cart_and_specail_offer_on_2_B() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsInCart = Arrays.asList("B","B","B");
        Assert.assertEquals(40, checkOutCalculator.calculatePrice(itemsInCart));
    }
}
