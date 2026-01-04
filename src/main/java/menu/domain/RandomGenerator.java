package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 4;
    public static final int MENU_ORDER = 0;

    public String generateCategory(List<String> categories) {
        return categories.get(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
    }

    public String generateMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(MENU_ORDER);
    }
}
