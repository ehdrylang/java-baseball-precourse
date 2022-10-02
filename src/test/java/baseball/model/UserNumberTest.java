package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserNumberTest {
    @DisplayName("사용자가 입력한 값은 숫자로만 이루어져 있지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"13#", "ddd", "i30", "", "   ", "일23", "one"})
    void constuctor_사용자가_입력한_값이_숫자가_아니면_예외가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 값의 길이가 3이 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "103 ", " 333", "1234"})
    void constuctor_사용자가_입력한_값의_길이가_3이_아니면_예외가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 숫자 중 중복된 숫자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"121", "441", "555", "133"})
    void constuctor_사용자가_입력한_값_중_중복이_있으면_예외가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0이 포함된 숫자를 입력하면 예외가 발생한다")
    @Test
    void constructor_0이_포함된_숫자를_입력하면_예외가_발생한다() {
        // given
        String input = "102";
        // when
        Assertions.assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 다른 수 3자리가 입력되면 정상적으로 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "356", "869", "589", "712"})
    void constructor_서로_다른_수_3자리가_입력되면_정상적으로_사용자의_수가_입력된다(String input) {
        // when
        UserNumber userNumber = new UserNumber(input);

        // then
        String savedInput = userNumber.getInput();
        Assertions.assertThat(input).isEqualTo(savedInput);
    }

}