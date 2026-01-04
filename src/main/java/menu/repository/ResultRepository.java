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
}
