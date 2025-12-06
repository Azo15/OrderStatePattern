public class PendingState implements OrderState {

    @Override
    public void ship(Order context) {
        System.out.println("Order shipped");
        context.setCurrentState(new ShippedState());
    }


    @Override
    public void deliver(Order context) {
        System.out.println("Cannot deliver a pending order");
    }
    @Override
    public void cancel(Order context) {
        System.out.println("Order cancelled");
        context.setCurrentState(new CancelledState());
    }

    public PendingState() {

    }
}
