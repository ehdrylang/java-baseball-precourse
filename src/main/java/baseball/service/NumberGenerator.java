package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 서로 다른 임의의 수를 생성해주는 클래스
 */
public class NumberGenerator {
    private final static int COUNT = 3;
    private final static int MIN = 1;
    private final static int MAX = 9;

    public static int[] generate() {
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < COUNT) {
            int value = pickNumberWithExcludedList(temp);
            temp.add(value);
        }
        return toIntArray(temp);
    }

    private static int pickNumberWithExcludedList(List<Integer> excludedList) {
        if (excludedList == null || excludedList.isEmpty()) {
            return Randoms.pickNumberInRange(MIN, MAX);
        }
        int value;
        do {
            value = Randoms.pickNumberInRange(MIN, MAX);
        } while (excludedList.contains(value));
        return value;
    }

    private static int[] toIntArray(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new int[]{};
        }
        int[] arrays = new int[numbers.size()];
        for (int i=0;i<numbers.size();i++) {
            int intValue = numbers.get(i);
            arrays[i] = intValue;
        }
        return arrays;
    }
}
