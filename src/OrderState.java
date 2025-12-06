public interface OrderState {

    void ship(Order context);
    void deliver(Order context);
    void cancel(Order context);
}
