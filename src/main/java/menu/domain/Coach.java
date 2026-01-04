package menu.domain;

import menu.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 4;

    private String name;
    private List<String> bannedMenus = new ArrayList<>();
    private List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME.getMessage());
        }
    }

    public void addBannedMenu(String name) {
        bannedMenus.add(name);
    }

    public void addRecommendMenu(String menu) {
        recommendedMenus.add(menu);
    }

    public boolean isBanned(String menu) {
        return bannedMenus.contains(menu);
    }

    public boolean isRecommend(String menu) {
        return recommendedMenus.contains(menu);
    }
}
