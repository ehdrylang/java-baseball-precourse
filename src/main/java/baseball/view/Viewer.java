package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Viewer {
    private static final String NUMBER_INPUT_REQUEST = "숫자를 입력해주세요 : ";
    private static final String CONGRATULATION_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String input() {
        System.out.print(NUMBER_INPUT_REQUEST);
        return Console.readLine();
    }

    public void win() {
        System.out.println(CONGRATULATION_TEXT);
    }

    public String continueOrNot() {
        System.out.println(CONTINUE_OR_NOT);
        return Console.readLine();
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }
}
