package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_COACHES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public String input() {
        return Console.readLine();
    }

    public String inputCoachNames() {
        System.out.println(INPUT_COACHES);
        return Console.readLine();
    }
}
