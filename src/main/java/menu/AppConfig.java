package menu;

import menu.controller.MenuController;
import menu.repository.MenuRepository;
import menu.repository.ResultRepository;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {
    private InputView inputView;
    private OutputView outputView;
    private MenuController menuController;
    private MenuService menuService;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public MenuService xService() {
        if (menuService == null) {
            menuService = new MenuService(
                    new MenuRepository(),
                    new ResultRepository());
        }
        return menuService;
    }

    public MenuController xController() {
        if (menuController == null) {
            menuController = new MenuController(inputView(), outputView(), xService());
        }
        return menuController;
    }
}
