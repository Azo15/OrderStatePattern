public class Main {
    public static void main(String[] args) {

        Order order = new Order(new PendingState());

        order.ship();      // Pending -> Shipped 
        order.deliver();   // Shipped -> Delivered
        order.cancel();    // Delivered -> Cannot cancel
    }
}
