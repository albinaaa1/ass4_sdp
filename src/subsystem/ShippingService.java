package subsystem;

public class ShippingService {
    public String scheduleDelivery(String customerId, String address, String itemId) {
        String trackingId = "TRK-" + System.currentTimeMillis() % 10000;
        System.out.println("[ShippingService] Delivery of the item has been arranged " + itemId + " at the address: " + address + ". Tracking number: " + trackingId);
        return trackingId;
    }
}