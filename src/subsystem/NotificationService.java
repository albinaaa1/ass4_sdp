package subsystem;

public class NotificationService {
    public void sendOrderConfirmation(String customerId, String trackingId) {
        System.out.println("[NotificationService] Notification sent to the client " + customerId + " : your order has been placed, tracking number: " + trackingId);
    }

    public void sendOrderFailureNotification(String customerId, String reason) {
        System.out.println("[NotificationService] Notification to the client " + customerId + " : Error placing order. Reason: " + reason);
    }
}