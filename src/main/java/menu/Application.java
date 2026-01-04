package menu;

import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MenuController menuController = appConfig.menuController();

        menuController.run();
    }
}
