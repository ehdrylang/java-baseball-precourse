package baseball.model;

import baseball.service.NumberGenerator;

/**
 * 사용자 게임의 상대인 컴퓨터 클래스
 * 임의의 숫자를 생성하고 사용자에게 일치 여부에 대한 힌트를 제공하는 역할을 담당한다.
 */
public class Computer {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private final int[] numbers;

    public Computer() {
        this.numbers = NumberGenerator.generate();
    }

    private static int same(int a, int b) {
        return a == b ? 1 : 0;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public String play(int[] numberToTry) {
        StringBuilder sb = new StringBuilder();
        int ballCount = getBallCount(numberToTry);
        if (ballCount > 0) {
            sb.append(ballCount).append(BALL);
        }
        int strikeCount = getStrikeCount(numberToTry);
        if (strikeCount > 0) {
            sb.append(" ").append(strikeCount).append(STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }
        return sb.toString().trim();
    }

    private int getBallCount(int[] numberToTry) {
        int count = 0;
        for (int i = 0; i < numberToTry.length; i++) {
            count += checkBall(i, numberToTry[i]);
        }
        return count;
    }

    private int checkBall(int index, int value) {
        if (numbers[index] == value) {
            return 0;
        }
        int count = 0;
        for (int number : numbers) {
            count += same(number, value);
        }
        return count;
    }

    private int getStrikeCount(int[] numberToTry) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            count += same(numbers[i], numberToTry[i]);
        }
        return count;
    }
}
