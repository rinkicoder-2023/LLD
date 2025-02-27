package org.coder.shoppingcart;

public interface DiscountStrategy {
    double applyDiscount(double total, ShoppingCart shoppingCart);
}
