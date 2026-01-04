package menu.service;

import menu.domain.Coach;
import menu.domain.RandomGenerator;
import menu.exception.ErrorMessage;
import menu.repository.MenuRepository;
import menu.repository.ResultRepository;
import menu.utils.InputConverter;
import menu.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private static final List<String> categories = List.of("일식", "한식", "중식", "아시안", "양식");

    private final MenuRepository menuRepository;
    private final ResultRepository resultRepository;
    private final RandomGenerator generator;

    public MenuService(MenuRepository menuRepository, ResultRepository resultRepository, RandomGenerator generator) {
        this.menuRepository = menuRepository;
        this.resultRepository = resultRepository;
        this.generator = generator;
    }

    public void saveCoaches(String input) {
        List<String> coachNames = InputConverter.convertInputToNames(input);
        Validator.validateCoachCount(coachNames);
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }
        resultRepository.saveCoaches(coaches);
    }

    public void initMenus() {
        menuRepository.saveMenus(categories.get(0), List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menuRepository.saveMenus(categories.get(1), List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menuRepository.saveMenus(categories.get(2), List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menuRepository.saveMenus(categories.get(3), List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menuRepository.saveMenus(categories.get(4), List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public List<Coach> findAllCoaches() {
        return resultRepository.findAllCoaches();
    }

    public void saveBannedMenu(Coach coach, String input) {
        List<String> menus = InputConverter.convertInputToNames(input);
        if (menus.isEmpty() || menus.get(0).isBlank()) {
            return;
        }
        Validator.validateBannedMenuSize(menus);
        for (String menuName : menus) {
            if (!menuRepository.existMenu(menuName)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_MENU.getMessage());
            }
        }
        for (String menu : menus) {
            coach.addBannedMenu(menu);
        }
    }

    public String generateRandomCategory() {
        return generator.generateCategory(categories);
    }

    public void validateDuplicatedCategory(String category) {
        if (resultRepository.validateDuplicatedCategory(category)) {
            throw new IllegalArgumentException();
        }
    }

    public void saveCategory(String category) {
        resultRepository.addCategory(category);
    }

    public void recommendMenu(Coach coach, String category) {
        List<String> menus = menuRepository.findMenuByCategory(category);
        while (true) {
            String recommendedMenu = generator.generateMenu(menus);
            if (!coach.isBanned(recommendedMenu) && !coach.isRecommend(recommendedMenu)) {
                coach.addRecommendMenu(recommendedMenu);
                break;
            }
        }
    }
}
