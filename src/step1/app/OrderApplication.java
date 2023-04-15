package step1.app;

import step1.enums.Menu;
import step1.service.ChickenService;
import step1.service.OrderService;
import step1.service.PizzaService;


// 요청에 대한 처리와 반환을 담당하는 Controller
public class OrderApplication implements Consumer{
    // Service Class가 Controller에 직접적으로 결합되어 있어서 이부분의 결합도를 느슨하게 해주려한다.
//    private final ChickenService chickenService = new ChickenService();
//    private final PizzaService pizzaService = new PizzaService();
    OrderService orderService;

    public OrderApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    // 고객이 요청한 메뉴와 수량을 입력 받음. (Request 요청)
    // Controller 는 해당 Request를 Service에게 전달
//    @Override
//    public void chickenOrder(Menu menu, int amount) {
//            orderService.saveOrder(menu, amount);
//    }
//
//    @Override
//    public void pizzaOrder(Menu menu, int amount) {
//            orderService.saveOrder(menu, amount);
//    }

    @Override
    public void order(Menu menu, int amount) {
        orderService.saveOrder(menu, amount);
    }
}
