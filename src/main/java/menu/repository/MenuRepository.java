package menu.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    private Map<String, List<String>> menuMap = new HashMap<>();

    public void saveMenus(String category, List<String> menus) {
        menuMap.put(category, menus);
    }

    public boolean existMenu(String name) {
        for (List<String> menus : menuMap.values()) {
            if (menus.contains(name)) {
                return true;
            }
        }
        return false;
    }
}
