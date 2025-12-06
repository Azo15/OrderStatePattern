public class DeliveredState implements OrderState {

    @Override
    public void ship(Order context) {
        System.out.println("Cannot ship a delivered order.");
    }

    @Override
    public void deliver(Order context) {
        System.out.println("Order is already delivered.");
    }

    @Override
    public void cancel(Order context) {
        System.out.println("Cannot cancel a delivered order.");
    }

    public DeliveredState() {
    }
}
