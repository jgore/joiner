package pl.decerto.joiner.service.joiner.elementJointer;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NumberAdditionElementJoiner implements ElementJoiner<Number> {

    private static NumberAdditionElementJoiner INSTANCE;

    private NumberAdditionElementJoiner() {

    }

    public static NumberAdditionElementJoiner getInstance() {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        if (INSTANCE == null) {
            INSTANCE = new NumberAdditionElementJoiner();
        }

        lock.unlock();

        return INSTANCE;
    }

    @Override
    public BigDecimal join(List<Number> numbers) {

        return numbers
                .parallelStream()
                .mapToDouble(Number::doubleValue)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

}
