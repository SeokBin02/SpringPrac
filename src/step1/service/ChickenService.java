package step1.service;


import step1.enums.Menu;
import step1.order.OrderList;

// Controller로 들어온 치킨주문요청(메뉴와 수량)을 기능적으로 처리하는 Service (Logic 담당)
public class ChickenService {
    private static OrderList orderList = new OrderList();

    // 요청받은 Request의 파라메터를 이용해서 Repository에 접근
    public void saveOrder(Menu menu, int amount){
        System.out.println("치킨 주문 완료");
        orderList.setOrder(menu, amount);
    }
}
