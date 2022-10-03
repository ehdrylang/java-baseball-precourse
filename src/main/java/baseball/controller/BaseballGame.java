package baseball.controller;

import baseball.model.Computer;
import baseball.model.ExitStatus;
import baseball.model.UserNumber;
import baseball.view.Viewer;

public class BaseballGame {
    private static final String CONTINUE = "1";
    private static final String EXIT = "2";
    private static final String ALL_STRIKE = "3스트라이크";

    private final Viewer viewer;
    private Computer computer;
    private ExitStatus exitStatus;

    public BaseballGame() {
        this.viewer = new Viewer();
        this.computer = new Computer();
        exitStatus = ExitStatus.CONTINUE;
    }

    public void start() {
        while (exitStatus != ExitStatus.EXIT) {
            String input = this.viewer.input();
            UserNumber userNumber = new UserNumber(input);
            String hint = computer.play(userNumber.getUserNumber());
            this.viewer.printHint(hint);
            exitStatus = checkTermination(hint);
        }
    }

    private void isValidInputForExit(String input) {
        if (!(CONTINUE.equals(input) || EXIT.equals(input))) {
            throw new IllegalArgumentException();
        }
    }

    private ExitStatus checkTerminationCondition(String condition) {
        if (CONTINUE.equals(condition)) {
            reset();
            return ExitStatus.CONTINUE;
        }
        return ExitStatus.EXIT;
    }

    private void reset() {
        this.computer = new Computer();
    }

    private ExitStatus checkTermination(String hint) {
        if (isAllStrike(hint)) {
            viewer.win();
            String input = viewer.continueOrNot();
            isValidInputForExit(input);
            return checkTerminationCondition(input);
        }
        return ExitStatus.CONTINUE;
    }

    private boolean isAllStrike(String hint) {
        return ALL_STRIKE.equals(hint);
    }
}
