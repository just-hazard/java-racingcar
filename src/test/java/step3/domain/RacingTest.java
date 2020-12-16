package step3.domain;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private Racing racing;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        racing = new Racing();
        carList = new ArrayList<>();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 6})
    @DisplayName("차량 객체 생성 테스트 코드")
    void carRegistration(int count) {
        assertThat(racing.carRegistration(count)).size().isEqualTo(count);
    }

    @Test
    @DisplayName("자동차 대수 만큼 전진 로직 루프 테스트 코드")
    void carsMove() {
        carList = Arrays.asList(new Car(), new Car(), new Car());
        racing.carsMove(carList);
        List<Integer> moveList = new ArrayList<>();
        for(Car car : carList)
            moveList.add(car.getPosition());
        assertThat(moveList).containsAnyOf(0,1);
    }
}
