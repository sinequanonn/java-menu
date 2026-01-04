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

        saveCoachNames();
        saveCoachBannedMenus();
        processMenuRecommendation();

        printResultStatus();
    }

    private void printResultStatus() {
        outputView.printDay();
        outputView.printCategories(menuService.findResultCategories());
        List<Coach> coaches = menuService.findAllCoaches();
        for (Coach coach : coaches) {
            outputView.printCoachRecommendMenus(coach.getName(), coach.getRecommendedMenus());
        }
        outputView.printSuccessMessage();
    }

    private void processMenuRecommendation() {
        for (int i = 0; i < 5; i++) {
            String category = generateRandomCategory();
            recommendMenu(category);
        }
    }

    private void recommendMenu(String category) {
        List<Coach> coaches = menuService.findAllCoaches();
        for (Coach coach : coaches) {
            menuService.recommendMenu(coach, category);
        }
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

    private void saveCoachBannedMenus() {
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

    public void saveCoachNames() {
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
