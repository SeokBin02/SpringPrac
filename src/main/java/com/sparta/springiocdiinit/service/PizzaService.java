package com.sparta.springiocdiinit.service;

import com.sparta.springiocdiinit.entity.Order;
import com.sparta.springiocdiinit.enums.Menu;
import com.sparta.springiocdiinit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// ChickenService를 @Pirmay 등록을 했기에 OrderService는 자동적으로 Chicken을 우선 주입하게된다.
// 하지만 PizzaController에서는 PizzaService를 사용해야 하므로 문제가 발생한다
// 이떄 PizzaService에 @Qualifier를 이용해서 추가 정보를 입력해서 중복을 피하는 방법을 사용한다.
// PizzaController에서 OrderService 의존주입을 할때 Spring은 Qualifier로 명시된 추가 정보까지 탐색을 해서 pizzaService를 의존주입한다
// 이때 Qualifier에서 오타가 발생하면 정보 탐색이 되지 않으니 오타 주의 할것!
@Service
@Qualifier("pizza")
public class PizzaService implements OrderService{
    private final OrderRepository orderRepository;

    @Autowired
    public PizzaService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void order(Menu menu, int amount) {
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount);
        this.orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders(Menu menu) {
        return orderRepository.findAllByFoodName(menu.getFoodName());
    }
}
