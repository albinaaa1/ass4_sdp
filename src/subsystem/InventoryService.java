package subsystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("Laptop", 5);
        stock.put("Phone", 10);
    }

    public boolean reserveStock(String itemId, int quantity) {
        int current = stock.getOrDefault(itemId, 0);
        if (current >= quantity) {
            stock.put(itemId, current - quantity);
            System.out.println("[InventoryService] Reserved " + quantity + " item(s): " + itemId);
            return true;
        }
        System.out.println("[InventoryService] Insufficient stock " + itemId + " in the warehouse.");
        return false;
    }

    public void releaseStock(String itemId, int quantity) {
        int current = stock.getOrDefault(itemId, 0);
        stock.put(itemId, current + quantity);
        System.out.println("[InventoryService] Reservation cancellation (Rollback): returned " + quantity + " units of product " + itemId);
    }
}