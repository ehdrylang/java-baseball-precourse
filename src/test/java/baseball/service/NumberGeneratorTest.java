package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class NumberGeneratorTest {

    @DisplayName("정확히 3개의 숫자를 생성해야한다")
    @Test
    void generate_리턴되는_배열의_길이는_3이어야_한다() {
        // when
        int[] numbers = NumberGenerator.generate();
        // then
        Assertions.assertThat(numbers).hasSize(3);
    }

    @DisplayName("서로 다른 수를 리턴해야 한다")
    @Test
    void generate_리턴되는_배열의_요소_중_같은_숫자가_있으면_안된다() {
        // when
        int[] numbers = NumberGenerator.generate();
        // then
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            numberSet.add(numbers[i]);
        }
        Assertions.assertThat(numbers.length).isEqualTo(numberSet.size());
    }

    @DisplayName("0을 제외한 숫자만 생성되어야 한다")
    @Test
    void generate_리턴되는_배열의_요소_중_0을_포함되면_안된다() {
        // when
        int[] numbers = NumberGenerator.generate();
        // then
        Assertions.assertThat(numbers).doesNotContain(0);
    }
}