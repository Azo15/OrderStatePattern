public class CancelledState implements OrderState {

    @Override
    public void ship(Order context) {
        System.out.println("Cannot ship a cancelled order.");
    }

    @Override
    public void deliver(Order context) {
        System.out.println("Cannot deliver a cancelled order.");
    }

    @Override
    public void cancel(Order context) {
        System.out.println("Order is already cancelled.");
    }

    public CancelledState() {
    }
}
