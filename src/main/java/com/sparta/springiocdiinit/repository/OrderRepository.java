package com.sparta.springiocdiinit.repository;

import com.sparta.springiocdiinit.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // JpaRepository는 최상위 interface Repositroy로 부터 상속을 받아 내려온 Interface이다
    // 사용방법은 JpaRepository<Entity Class, ID> 즉 Entity Class와 해당 Entity의 ID를 받아 온다.
    // JpaRepositroy는 내부적으로 메서드가 선언되어 있고 해당 메서드는 Spring에서 자동으로 생성해주기때문에 바로 메서드를 끌어다 사용가능
    List<Order> findAllByFoodName(String foodName);
}

