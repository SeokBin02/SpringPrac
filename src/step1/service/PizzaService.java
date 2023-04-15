package step1.service;


import step1.enums.Menu;
import step1.order.OrderList;

// Controller로 들어온 피자주문요청(메뉴와 수량)을 기능적으로 처리하는 Service (Logic 담당)
public class PizzaService {
    private static OrderList orderList = new OrderList();
    public void saveOrder(Menu menu, int amount){
        System.out.println("피자 주문 완료");
        orderList.setOrder(menu, amount);
    }
}
