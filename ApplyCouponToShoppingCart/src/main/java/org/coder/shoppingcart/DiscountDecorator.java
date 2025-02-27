package org.coder.shoppingcart;

public abstract class DiscountDecorator implements DiscountStrategy{

    protected DiscountStrategy wrappedDiscount;

    public DiscountDecorator(DiscountStrategy wrappedDiscount) {
        this.wrappedDiscount = wrappedDiscount;
    }

    @Override
    public double applyDiscount(double total, ShoppingCart shoppingCart) {
        return wrappedDiscount.applyDiscount(total, shoppingCart);
    }
}
