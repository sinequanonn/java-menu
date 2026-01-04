package menu.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {
    public static final String COMMA_DELIMITER = ",";
    public static List<String> convertInputToCoachNames(String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
