package facade;

import subsystem.*;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public boolean placeOrder(String customerId, String itemId, int quantity, double price, String address, String cardDetails) {
        System.out.println("\n--- START OF ORDER PLACEMENT ---");

        // 1. Резервирование товара
        if (!inventoryService.reserveStock(itemId, quantity)) {
            notificationService.sendOrderFailureNotification(customerId, "Item out of stock");
            return false;
        }

        // 2. Обработка платежа
        boolean paymentSuccess = paymentProcessor.processPayment(customerId, price * quantity, cardDetails);
        if (!paymentSuccess) {
            // Rollback (Откат) резерва товара при ошибке оплаты
            inventoryService.releaseStock(itemId, quantity);
            notificationService.sendOrderFailureNotification(customerId, "Payment error");
            return false;
        }

        // 3. Планирование доставки
        String trackingId = shippingService.scheduleDelivery(customerId, address, itemId);

        // 4. Отправка уведомления
        notificationService.sendOrderConfirmation(customerId, trackingId);
        System.out.println("--- ORDER SUCCESSFULLY PLACED ---");
        return true;
    }
}