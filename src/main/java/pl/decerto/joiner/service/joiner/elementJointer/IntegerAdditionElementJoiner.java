package pl.decerto.joiner.service.joiner.elementJointer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerAdditionElementJoiner implements ElementJoiner<Integer> {

    private static IntegerAdditionElementJoiner INSTANCE;

    private IntegerAdditionElementJoiner() {

    }

    public static IntegerAdditionElementJoiner getInstance() {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        if (INSTANCE == null) {
            INSTANCE = new IntegerAdditionElementJoiner();
        }

        lock.unlock();

        return INSTANCE;
    }

    @Override
    public Integer join(List<Integer> ints) {
        return ints.stream()
                .mapToInt(x -> x)
                .sum();
    }

}
