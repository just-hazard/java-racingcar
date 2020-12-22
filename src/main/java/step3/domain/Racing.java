package step3.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private Cars cars;
    private final CarMovingStrategy carMovingStrategy = new CarMovingStrategy();


    public static Cars racingGameStart(int createCarCount) {
        return new Cars(createCarCount);
    }

    protected void carsMove() {
        cars.getCars().forEach(s -> s.move(carMovingStrategy));
    }

    public void numberOfCarMove(int moveCount) {
        IntStream.range(0,moveCount).forEach(i -> carsMove());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}
