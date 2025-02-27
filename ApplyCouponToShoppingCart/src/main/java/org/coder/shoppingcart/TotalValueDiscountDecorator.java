package org.coder.shoppingcart;

public class TotalValueDiscountDecorator extends DiscountDecorator{
    public TotalValueDiscountDecorator(DiscountStrategy wrappedDiscount) {
        super(wrappedDiscount);
    }

    @Override
    public double applyDiscount(double total, ShoppingCart shoppingCart) {
        double discountAmount = 0.0;

        if(total > 500) {
            discountAmount = total * 0.20;
        } else if (total > 200) {
            discountAmount = total * 0.15;
        }
        return wrappedDiscount.applyDiscount(total - discountAmount, shoppingCart);
    }
}
