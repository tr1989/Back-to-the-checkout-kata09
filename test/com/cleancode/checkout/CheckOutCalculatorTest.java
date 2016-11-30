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
}
