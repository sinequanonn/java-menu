package menu.exception;

public enum ErrorMessage {
    INVALID("유효하지 않은 입력입니다."),
    INVALID_COACH_COUNT("코치는 최소 2명 이상 5명 이하여야 합니다."),
    INVALID_COACH_NAME("코치 이름은 2자 이상 4자 이하여야 합니다."),
    INVALID_MENU_SIZE("먹지 못하는 메뉴는 최소 0개, 최대 2개입니다."),
    NOT_FOUND_MENU("존재하지 않는 메뉴입니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
