package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

class ComputerTest {
    private static final int[] COMPUTER_NUMBERS = new int[]{1, 2, 3};
    private static Computer computer;

    @BeforeAll
    static void init() throws NoSuchFieldException, IllegalAccessException {
        computer = new Computer();
        Field numbersField = computer.getClass()
                .getDeclaredField("numbers");
        numbersField.setAccessible(true);
        numbersField.set(computer, COMPUTER_NUMBERS);
    }

    @ParameterizedTest
    @DisplayName("숫자와 자리가 하나도 맞는게 없으면 '낫싱'이 리턴된다")
    @CsvSource({"4,5,6", "7,8,9"})
    void play_숫자와_자리_아무것도_일치하는게_없는_경우_낫싱_리턴(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("낫싱");
    }

    @ParameterizedTest
    @DisplayName("자릿수가 일치하는게 하나도 없고 숫자가 존재하는게 1개라면 1볼이다")
    @CsvSource({"2,5,6", "7,1,9", "3,6,4", "5,3,8"})
    void play_자릿수_불일치_숫자는_1개만_포함(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("1볼");
    }

    @ParameterizedTest
    @DisplayName("자릿수가 일치하는게 하나도 없고 숫자가 존재하는게 2개라면 2볼이다")
    @CsvSource({"2,3,6", "7,1,2", "3,6,1", "5,3,1"})
    void play_자릿수_불일치_숫자는_2개만_포함(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("2볼");
    }

    @ParameterizedTest
    @DisplayName("자릿수가 일치하는게 하나도 없고 숫자가 존재하는게 3개라면 3볼이다")
    @CsvSource({"2,3,1", "3,1,2"})
    void play_자릿수_불일치_숫자는_3개_포함(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("3볼");
    }

    @ParameterizedTest
    @DisplayName("자릿수가 1개 일치, 나머지 숫자 미포함이면 1스트라이크다")
    @CsvSource({"1,5,6", "7,2,8", "4,9,3"})
    void play_자릿수_1개일치_나머지_숫자_미포함(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("1스트라이크");
    }

    @ParameterizedTest
    @DisplayName("자릿수가 2개 일치, 나머지 숫자 미포함이면 2스트라이크다")
    @CsvSource({"1,2,6", "7,2,3", "1,9,3"})
    void play_자릿수_2개일치_나머지_숫자_미포함(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("자릿수가 3개 일치는 3스트라이크다")
    void play_자릿수_3일치() {
        // given
        int[] input = COMPUTER_NUMBERS;
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("3스트라이크");
    }

    @ParameterizedTest
    @DisplayName("자릿수가 1개 일치, 나머지 숫자 1개 포함이면 1볼 1스트라이크다")
    @CsvSource({"1,6,2", "7,2,1", "1,3,9"})
    void play_자릿수_1개일치_나머지_숫자_1개포함(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("1볼 1스트라이크");
    }

    @ParameterizedTest
    @DisplayName("자릿수가 1개 일치, 나머지 숫자 2개 포함이면 2볼 1스트라이크다")
    @CsvSource({"1,3,2", "2,1,3", "3,2,1"})
    void play_자릿수_1개일치_나머지_숫자_2개포함(int first, int second, int third) {
        // given
        int[] input = new int[]{first, second, third};
        // when
        String play = computer.play(input);
        // then
        Assertions.assertThat(play).isEqualTo("2볼 1스트라이크");
    }


}