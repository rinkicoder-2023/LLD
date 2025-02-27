package org.coder.shoppingcart;

public class FixedAmountCouponDecorator extends DiscountDecorator{
    private final double discountAmount;

    public FixedAmountCouponDecorator(DiscountStrategy wrappedDiscount, double discountAmount) {
        super(wrappedDiscount);
        this.discountAmount = discountAmount;
    }


    @Override
    public double applyDiscount(double total, ShoppingCart shoppingCart) {
        double finalAmount = Math.max(0, total - discountAmount);
        return wrappedDiscount.applyDiscount(finalAmount, shoppingCart);
    }
}
