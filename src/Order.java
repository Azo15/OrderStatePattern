public class Order {

    //Current state
    private OrderState currentState;

    //Constructure
    public Order(OrderState initialState) {
        this.currentState = initialState;
    }

    //Get-Set
    public OrderState getCurrentState() {
        return currentState;
    }
    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }


    public void ship() {
        this.currentState.ship(this);
    }
    public void deliver() {
        this.currentState.deliver(this);
    }
    public void cancel() {
        this.currentState.cancel(this);
    }



}
