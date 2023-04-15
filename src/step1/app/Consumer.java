package step1.app;

import step1.enums.Menu;

public interface Consumer {
    public void chickenOrder(Menu menu, int amount);
    public void pizzaOrder(Menu menu, int amount);
}

