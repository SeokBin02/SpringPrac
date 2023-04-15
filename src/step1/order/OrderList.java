package step1.order;

import step1.enums.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Service에서 요구하는 dateBase를 처리하는 Repository
public class OrderList {
    private String foodName;
    private String userName;
    private String password;

    // Consumer의 아이디 비밀번호를 입력받아 Database에 접근
    public OrderList(String foodName, String userName, String password) {
        this.foodName = foodName;
        this.userName = userName;
        this.password = password;
    }

    // 모든 클래스가 접근할 수 있도록 static 선언을 해준다.
    private static List<Order> orderList = new ArrayList<>();

    // Service로 부터 전달받은 Menu, amount를 파라메터로 받아서
    // Table insert into 즉 Order객체를 인스턴스화 시켜 필드에 저장한 후에
    // Order 타입의 list  즉 Repository에 저장한다.

    // 주문 저장할때 메뉴명으로 구분해서 저장.
    public void setOrderList(Order order){
        orderList.add(order);
        System.out.println(foodName + "주문 저장완료");
    }

    // Repository에 저장된 date를 불러오는 메서드
    public List<Order> getOrderList(){
        if(foodName.equals("치킨")){
            return orderList.stream().filter(f->f.getFoodName().equals("치킨")).collect(Collectors.toList());
        } else if (foodName.equals("피자")) {
            return orderList.stream().filter(f->f.getFoodName().equals("피자")).collect(Collectors.toList());
        } else{
            return orderList;
        }
    }
}
