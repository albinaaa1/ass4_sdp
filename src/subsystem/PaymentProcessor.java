package subsystem;

public class PaymentProcessor {
    public boolean processPayment(String customerId, double amount, String cardDetails) {
        if (cardDetails == null || cardDetails.equals("INVALID_CARD")) {
            System.out.println("[PaymentProcessor] Error: Payment declined for the customer " + customerId);
            return false;
        }
        System.out.println("[PaymentProcessor] Successfully debited $" + amount + " at the client's site " + customerId);
        return true;
    }
}