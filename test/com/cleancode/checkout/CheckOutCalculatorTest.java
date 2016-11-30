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
}
