package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_COACHES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_BANNED_MENUS_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public String input() {
        return Console.readLine();
    }

    public String inputCoachNames() {
        printEmptyLine();
        System.out.println(INPUT_COACHES);
        return Console.readLine();
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public String inputCoachBannedMenu(String name) {
        printEmptyLine();
        System.out.printf(INPUT_BANNED_MENUS_FORMAT, name);
        return Console.readLine();
    }
}
