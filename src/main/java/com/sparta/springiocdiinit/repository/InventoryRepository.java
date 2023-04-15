package com.sparta.springiocdiinit.repository;


import com.sparta.springiocdiinit.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

// 이 프로젝트에서 데이터베이스를 하나더 연결해야 되는 상황이 생겼다는 가정
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
