package com.sparta.springiocdiinit.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// JPA Entity
// Repository의 table로 쓸 Entity class
@Getter                             // lombok을 이용해서 getter 메서드를 일괄적으로 Spring이 알아서 생성해줌
@Entity(name = "orders")            // @Entity는 해당 Class를 JPA에서 관리하는 객체로 선언하는 의미이다. Order는 Java에 예약어로 등록되어있어서 orders라는 별칭을 지어줬다.
public class Order {
//    IDENTITY : 기본 키 생성을 데이터베이스에 위임하는 방법 (데이터베이스에 의존적)
//               - 주로 MySQL, PostgresSQL, SQL Server, DB2에서 사용합니다.
//    SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본 키를 할당하는 방법 (데이터베이스에 의존적)
//               - 주로 시퀀스를 지원하는 Oracle, PostgresSQL, DB2, H2에서 사용합니다.
//                - @SequenceGenerator를 사용하여 시퀀스 생성기를 등록하고, 실제 데이터베이스의 생성될 시퀀스이름을 지정해줘야 합니다.
//    TABLE : 키 생성 테이블을 사용하는 방법
//               - 키 생성 전용 테이블을 하나 만들고 여기에 이름과 값으로 사용할 컬럼을 만드는 방법입니다.
//               - 테이블을 사용하므로, 데이터베이스 벤더에 상관없이 모든 데이터베이스에 적용이 가능합니다.
//    AUTO : 데이터베이스 벤더에 의존하지 않고, 데이터베이스는 기본키를 할당하는 벙법
//               - 데이터베이스에 따라서 IDENTITY, SEQUENCE, TABLE 방법 중 하나를 자동으로 선택해주는 방법입니다.
//               - 예를들어, Oracle일 경우 SEQUENCE를 자동으로 선택해서 사용합니다. 따라서, 데이터베이스를 변경해도 코드를 수정할 필요가 없습니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private int price;
    private int amount;

    public Order() {}

    public Order(String foodName, int price, int amount) {
        this.foodName = foodName;
        this.price = price;
        this.amount = amount;
    }
}