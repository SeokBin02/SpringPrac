package step1.app;

import step1.enums.Menu;

public interface Consumer {
    // 똑같은 기능을 하는 메서드를 하나로 규합
    public void order(Menu menu, int amount);
//    public void chickenOrder(Menu menu, int amount);
//    public void pizzaOrder(Menu menu, int amount);
}

