package step1.app;

import step1.enums.Menu;
import step1.service.ChickenService;
import step1.service.PizzaService;


// 요청에 대한 처리와 반환을 담당하는 Controller
public class OrderApplication implements Consumer{
    private final ChickenService chickenService = new ChickenService();
    private final PizzaService pizzaService = new PizzaService();


    // 고객이 요청한 메뉴와 수량을 입력 받음. (Request 요청)
    // Controller 는 해당 Request를 Service에게 전달
    @Override
    public void chickenOrder(Menu menu, int amount) {
            chickenService.saveOrder(menu, amount);
    }

    @Override
    public void pizzaOrder(Menu menu, int amount) {
            pizzaService.saveOrder(menu, amount);
    }
}
