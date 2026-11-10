package org.chivqsss.shop.order;

import java.util.List;

public class OrderService {
    private static final double DISCOUNT_THRESHOLD = 1000.0;
    private static final double DISCOUNT_RATE = 0.9;

    /**
     * Обчислює підсумкову вартість замовлення з урахуванням знижки.
     *
     * @param items  позиції замовлення, не може бути null
     * @param status статус замовлення
     * @return підсумкова вартість замовлення
     */
    public double calculateOrderTotal(List<OrderItem> items, OrderStatus status) {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }
        double total = calculateItemsTotal(items);
        return isDiscountApplicable(status, total) ? total * DISCOUNT_RATE : total;
    }

    private double calculateItemsTotal(List<OrderItem> items) {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.price() * item.quantity();
        }
        return total;
    }

    private boolean isDiscountApplicable(OrderStatus status, double total) {
        return status == OrderStatus.PAID && total > DISCOUNT_THRESHOLD;
    }

    public enum OrderStatus {NEW, PAID, SHIPPED, CANCELLED}

    public record OrderItem(double price, int quantity) {
    }
}