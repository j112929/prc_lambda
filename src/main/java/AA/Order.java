package AA;

public class Order {
    private final int orderNum;
    private final double orderAmount;
    private final double orderDiscount;

    public Order(int orderNumber, double orderAmt,
                 double orderDisc) {
        orderNum = orderNumber;
        orderAmount = orderAmt;
        orderDiscount = orderDisc;
    }

    public double finalOrderTotal() {
        return orderAmount - orderAmount *
                orderDiscount;
    }
}

