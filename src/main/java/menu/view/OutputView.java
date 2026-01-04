package menu.view;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.\n" +
            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORIES_MESSAGE = "[ 카테고리 | %s | %s | %s | %s | %s ]\n";
    private static final String COACHES_MESSAGE = "[ %s | %s | %s | %s | %s | %s ]\n";
    private static final String SUCCESS_MESSAGE = "추천을 완료했습니다.";


    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printDay() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCategories(List<String> categories) {
        System.out.printf(CATEGORIES_MESSAGE,
                categories.get(0),
                categories.get(1),
                categories.get(2),
                categories.get(3),
                categories.get(4));
    }

    public void printCoachRecommendMenus(String name, List<String> menus) {
        System.out.printf(COACHES_MESSAGE,
                name,
                menus.get(0),
                menus.get(1),
                menus.get(2),
                menus.get(3),
                menus.get(4));
    }

    public void printSuccessMessage() {
        printEmptyLine();
        System.out.println(SUCCESS_MESSAGE);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
