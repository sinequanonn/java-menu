package menu.domain;

public enum Category {
    JAPAN("1", "일식"),
    KOREA("2", "한식"),
    CHINA("3", "중식"),
    ASIA("4", "아시안"),
    WEST("5", "양식"),
    ;

    private final String order;
    private final String name;

    Category(final String order, final String name) {
        this.order = order;
        this.name = name;
    }
}
