package org.coder.shoppingcart;

import java.util.Map;

public class CategoryDiscountDecorator extends DiscountDecorator{

    private static final Map<Category, Double> CATEGORY_DISCOUNTS = Map.of(
            Category.ELECTRONICS,0.10,
            Category.GROCERIES,0.05);


    public CategoryDiscountDecorator(DiscountStrategy wrappedDiscount) {
        super(wrappedDiscount);
    }

    @Override
    public double applyDiscount(double total, ShoppingCart shoppingCart) {
        double discountAmount = shoppingCart.getProducts().stream()
                .filter(product -> product.getCategory() != null) // Null safety check
                .mapToDouble(product -> product.getPrice() * CATEGORY_DISCOUNTS.getOrDefault(product.getCategory(), 0.0))
                .sum();

        double finalAmount = total - discountAmount;
        return wrappedDiscount.applyDiscount(finalAmount, shoppingCart);
    }
}
