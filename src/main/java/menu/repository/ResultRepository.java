package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {
    private List<Coach> coaches = new ArrayList<>();
    private List<String> categories = new ArrayList<>();

    public void saveCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> findAllCoaches() {
        return coaches;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public boolean validateDuplicatedCategory(String category) {
        return categories.stream()
                .filter(name -> name.equals(category))
                .count() >= 2;
    }

    public List<String> findCategories() {
        return categories;
    }
}
