package org.coder.shoppingcart;

public class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double total, ShoppingCart shoppingCart) {
        return total;
    }
}
