package com.sparta.springiocdiinit.controller;

import com.sparta.springiocdiinit.entity.Order;
import com.sparta.springiocdiinit.enums.Menu;
import com.sparta.springiocdiinit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 현재 PizzaController와 ChickenController가 동일한 url를 사용하고 있기때문에 runtime에서 Mapping이 중복으로 일어나서 에러가 발생한다.
// 따라서 @RequestMapping( ) 부분에 mapping을 세부화 시켜서 url의 중복을 피하고 있다.
@RestController
@RequestMapping("/pizza")
public class PizzaController {
    private final OrderService orderService;

    @Autowired
    public PizzaController(@Qualifier("pizza")OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/saveOrder/{amount}")
    public void saveOrder(@PathVariable int amount){
        this.orderService.order(Menu.Pizza, amount);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders(){
        return this.orderService.getOrders(Menu.Pizza);
    }

}
