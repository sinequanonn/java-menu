package menu.controller;

import menu.domain.Coach;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        menuService.initMenus();
        outputView.printStartMessage();

        inputCoachNames();
        inputCoachBannedMenus();
        processMenuRecommendation();
    }

    private void processMenuRecommendation() {
        String category = generateRandomCategory();

    }

    private String generateRandomCategory() {
        while (true) {
            try {
                String category = menuService.generateRandomCategory();
                menuService.validateDuplicatedCategory(category);
                menuService.saveCategory(category);
                return category;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void inputCoachBannedMenus() {
        List<Coach> coaches = menuService.findAllCoaches();
        for (Coach coach : coaches) {
            inputCoachBannedMenu(coach);
        }
    }

    private void inputCoachBannedMenu(Coach coach) {
        while (true) {
            try {
                String input = inputView.inputCoachBannedMenu(coach.getName());
                menuService.saveBannedMenu(coach, input);
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    public void inputCoachNames() {
        while (true) {
            try {
                String coaches = inputView.inputCoachNames();
                menuService.saveCoaches(coaches);
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    private <T> T execute(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }
}
