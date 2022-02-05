package pl.javastart.foodieapp.order;

public enum OrderStatus {
    NEW,
    IN_PROGRESS,
    COMPLETE;

    static OrderStatus nextStatus(OrderStatus status) {
        if (status == NEW)
            return IN_PROGRESS;
        else if (status == IN_PROGRESS)
            return COMPLETE;
        else
            throw new IllegalArgumentException("There is no next status for provided value");
    }

}