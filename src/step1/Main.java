package step1;


import step1.app.Consumer;
import step1.app.OrderApplication;
import step1.enums.Menu;
import step1.order.Order;
import step1.order.OrderList;
import step1.service.ChickenService;
import step1.service.OrderService;
import step1.service.PizzaService;

public class Main {
    public static void main(String[] args) {
        Consumer consumer;
        OrderService orderService;

        // 치킨 주문 요청
        orderService = new ChickenService(new OrderList("치킨", "Katarina", "1234"));
        consumer = new OrderApplication(orderService);
        consumer.order(Menu.Chicken, 3);
        consumer.order(Menu.Chicken, 4);
        consumer.order(Menu.Chicken, 8);
        consumer.order(Menu.Chicken, 11);
        consumer.order(Menu.Chicken, 1);
        // 요청 받은 Request 확인
        OrderList orderList = new OrderList("치킨", "Katarina", "1234");
        for(Order order : orderList.getOrderList()){
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }

        // 피자 주문 요청
        orderService = new PizzaService(new OrderList("피자", "Ben", "5555"));
        consumer = new OrderApplication(orderService);
        consumer.order(Menu.Pizza, 2);
        consumer.order(Menu.Pizza, 21);
        consumer.order(Menu.Pizza, 3);
        consumer.order(Menu.Pizza, 7);

        // 요청 받은 Request 확인
        orderList = new OrderList("피자", "Ben", "5555");
        for(Order order : orderList.getOrderList()){
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }
    }
}
