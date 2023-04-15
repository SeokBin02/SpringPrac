package step1;


import step1.app.Consumer;
import step1.app.OrderApplication;
import step1.enums.Menu;
import step1.order.Order;
import step1.order.OrderList;

public class Main {
    public static void main(String[] args) {
        Consumer consumer;
        consumer = new OrderApplication();

        // 치킨 주문 요청
        consumer.chickenOrder(Menu.Chicken, 3);
        // 요청 받은 Request 확인
        OrderList orderList = new OrderList();
        for(Order order : orderList.getOrderList()){
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
            System.out.println("=".repeat(30));
        }

        // 피자 주문 요청
        consumer.pizzaOrder(Menu.Pizza, 5);
        // 요청 받은 Request 확인
        for(Order order : orderList.getOrderList()){
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
            System.out.println("=".repeat(30));
        }
    }
}
