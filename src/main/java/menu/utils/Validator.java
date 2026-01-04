package menu.utils;

import menu.exception.ErrorMessage;

import java.util.List;

public class Validator {
    public static void validateCoachCount(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_COUNT.getMessage());
        }
    }

    public static void validateBannedMenuSize(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_SIZE.getMessage());
        }
    }
}
