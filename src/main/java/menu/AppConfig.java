package menu;

import menu.controller.MenuController;
import menu.domain.RandomGenerator;
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

    public MenuService menuService() {
        if (menuService == null) {
            menuService = new MenuService(
                    new MenuRepository(),
                    new ResultRepository(),
                    new RandomGenerator());
        }
        return menuService;
    }

    public MenuController menuController() {
        if (menuController == null) {
            menuController = new MenuController(inputView(), outputView(), menuService());
        }
        return menuController;
    }
}
