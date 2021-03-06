package pl.decerto.joiner.service.joiner.elementJointer;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerSubtractionListJoiner implements ElementJoiner<Number> {

    private static IntegerSubtractionListJoiner INSTANCE;

    private IntegerSubtractionListJoiner() {

    }

    public static IntegerSubtractionListJoiner getInstance() {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        if (INSTANCE == null) {
            INSTANCE = new IntegerSubtractionListJoiner();
        }
        lock.unlock();

        return INSTANCE;
    }


    @Override
    public Number join(List<Number> numbers) {

        return numbers
                .parallelStream()
                .mapToDouble(Number::doubleValue)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::subtract);
    }

}
