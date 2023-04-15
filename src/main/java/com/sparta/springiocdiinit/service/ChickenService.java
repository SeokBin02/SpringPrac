package com.sparta.springiocdiinit.service;


import com.sparta.springiocdiinit.entity.Order;
import com.sparta.springiocdiinit.enums.Menu;
import com.sparta.springiocdiinit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


// Ctrl + I : interface의 메서드 Overriding 생성
// @Autowired 부분에서 에러가 발생한다. 이유는 interface OrderService의 구현체로 ChickenService, PizzaService 이렇게 2개가 존재하기 떄문에
// Spring Container가어떤 것을 사용해서 의존주입해야 하느냐 라는 문제가 발생한다.
// @Primary는 이러한 중복 상태에서 우선순위를 가지게 하는 어노테이션이다. 다음과같이 ChickenService에 Primary 선언을 하게되면
// OrderService 의존 주입 상황에서 가장 높은 우선순위를 가지게된다. 그러나 Primary또한 중복선언되면 똑같이 에러가 발생하니 주의하도록 하자.
@Service
@Primary
public class ChickenService implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public ChickenService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void order(Menu menu, int amount) {
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders(Menu menu) {
        List<Order> allByFoodName = orderRepository.findAllByFoodName(menu.getFoodName());
        for (Order order : allByFoodName) {
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }
        return allByFoodName;
    }
}
