package com.sparta.springiocdiinit.controller;

import com.sparta.springiocdiinit.entity.Order;
import com.sparta.springiocdiinit.enums.Menu;
import com.sparta.springiocdiinit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller를 명시하는 어노테이션으로 기존 @Controller와의 차이점은 RequestBody를 포함한 Constroller라고 볼 수 있다.
// @어노테이션등록이 된 class를 전부 추적해서 IOC Container에 bean으로 등록을 한다
// Bean은 어노테이션 등록된 class를 객체로 만들어서 관리하는 것을 말한다.
// 따라서 ChickenController Class를 @RestController를 사용해서 Bean으로 IOC Container에 등록했다.
@RestController
@RequestMapping("/chicken")
public class ChickenController {

    private final OrderService orderService;

    @Autowired
    public ChickenController(OrderService orderService) {
        this.orderService = orderService;
    }
    // Java의 static main메서드에서 Injection해야 했던 것을 Spring이 해당 Class type에 맞게 자동으로 Injection처리를 해줌
    // 원래는 사용자가 main메서드에서 Injection을 제어했다면 Autowired를 사용해서 Spring에게 그 제어권을 넘겨주는 것이다 이를 제어의 역전이라 부른다.
    // Autowired를 쓰기 위해서는 해당 Class가 bean으로 등록이 되어 있어야 쓸 수 있다.
    // 즉 Spring Container에 여러가지 Bean으로 등록된 Class가 있고 그 중에서 주입하려는 type을 선택해서 Injection해주는 것.

    @PostMapping("/saveOrder/{amount}")
    public void saveOrder(@PathVariable int amount){
        this.orderService.order(Menu.Chicken, amount);
    }
    //    @RequestMapping(method = RequestMethod.POST) 와 동일하다.
    //    @RequestMapping
    //    요청받은 url을 따라오는 메서드와 mapping해주는 메서드다
    //    method의 설정이 없다면 default는 GET방식이다.

    //    @PathVariable
    //    위 요청 받은 url에서 특정값을 변수로 받아 줄 수 있다.
    //    전달받은 변수를 @PathVariable로 지정한 변수에 파라메터로 value로 저장해서 사용할 수 있다.

    @GetMapping("/getOrders")
    public List<Order> getOrders(){
        return orderService.getOrders(Menu.Chicken);
    }
}
