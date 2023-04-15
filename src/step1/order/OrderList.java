package step1.order;

import step1.enums.Menu;

import java.util.ArrayList;
import java.util.List;

// Service에서 요구하는 dateBase를 처리하는 Repository
public class OrderList {

    // 모든 클래스가 접근할 수 있도록 static 선언을 해준다.
    private static List<Order> orderList = new ArrayList<>();

    // Service로 부터 전달받은 Menu, amount를 파라메터로 받아서
    // Table insert into 즉 Order객체를 인스턴스화 시켜 필드에 저장한 후에
    // Order 타입의 list  즉 Repository에 저장한다.
    public void setOrder(Menu menu, int amount){
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount);
        orderList.add(order);
        System.out.println("주문 완료");
    }

    // Repository에 저장된 date를 불러오는 메서드
    public List<Order> getOrderList(){
        return orderList;
    }
}
