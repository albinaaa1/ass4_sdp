package client;

import facade.OrderFacade;

public class Main {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();

        // Сценарий 1: Успешное оформление заказа
        orderFacade.placeOrder("CUST-101", "Laptop", 1, 1200.00, "Astana, Mangilik El 55", "4532-XXXX-XXXX-8888");

        // Сценарий 2: Ошибка оплаты (проверка отката/rollback)
        orderFacade.placeOrder("CUST-102", "Phone", 2, 800.00, "Taraz, Abay St 12", "INVALID_CARD");
    }
}