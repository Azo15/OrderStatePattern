public class ShippedState implements OrderState {

    @Override
    public void ship(Order context) {
        System.out.println("Order is already shipped.");
    }

    @Override
    public void deliver(Order context) {
        System.out.println("Order delivered.");
        context.setCurrentState(new DeliveredState());
    }

    @Override
    public void cancel(Order context) {
        System.out.println("Cannot cancel a shipped order.");
    }

    public ShippedState() {
    }
}
