package baseball.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 사용자가 입력한 숫자를 다루는 클래스
 */
public class UserNumber {
    private static final int LENGTH = 3;

    private final String input; // 사용자가 입력한 값

    public UserNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (!isValidLength(input) || !isDigit(input) || containsDuplicatedNumber(input)) {
            throw new IllegalArgumentException();
        }
        this.input = input;
    }

    /**
     * 길이가 3인지 확인하는 메서드
     */
    private boolean isValidLength(String input) {
        return input.length() == LENGTH;
    }

    /**
     * 1~9 숫자로만 이루어져 있는지 확인하는 메서드
     */
    private boolean isDigit(String input) {
        return input != null && input.matches("[1-9.]+");
    }

    /**
     * 중복된 숫자가 포함되어 있는지 확인하는 메서드
     */
    private boolean containsDuplicatedNumber(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        return input.length() != set.size();
    }

    public String getInput() {
        return input;
    }
}
