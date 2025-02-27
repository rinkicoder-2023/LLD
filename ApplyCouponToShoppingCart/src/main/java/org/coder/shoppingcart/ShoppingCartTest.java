package org.coder.shoppingcart;

public class ShoppingCartTest {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct(new Product(101, "iPhone 15", Category.ELECTRONICS, 999));
        cart.addProduct(new Product(102, "Rice (5kg)", Category.GROCERIES, 40));
        cart.addProduct(new Product(103, "T-Shirt", Category.CLOTHING, 50));
        cart.addProduct(new Product(104, "Air Fryer", Category.HOME_APPLIANCES, 120));
        // Applying discounts using decorator pattern
        System.out.println("Total Price before discount: $" + cart.getTotalPrice());

        // Apply category-based discount
        DiscountStrategy discountStrategy = new CategoryDiscountDecorator(new NoDiscount());
        double discountedPrice = discountStrategy.applyDiscount(cart.getTotalPrice(), cart);
        System.out.println("Price after Category Discount: $" + discountedPrice);

        // Apply fixed amount discount ($50 off)
        discountStrategy = new FixedAmountCouponDecorator(discountStrategy, 50);
        discountedPrice = discountStrategy.applyDiscount(cart.getTotalPrice(), cart);
        System.out.println("Price after Fixed Amount Discount ($50 off): $" + discountedPrice);

        // Apply percentage discount (10% off)
        discountStrategy = new TotalValueDiscountDecorator(discountStrategy);
        discountedPrice = discountStrategy.applyDiscount(cart.getTotalPrice(), cart);
        System.out.println("Final Price after 10% Discount: $" + discountedPrice);

    }
}
