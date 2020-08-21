package pl.decerto.joiner.service.joiner.elementJointer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerSubtractionListJoiner implements ElementJoiner<Integer> {

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
    public Integer join(List<Integer> ints) {
        int sum = 0;
        for (Integer integer : ints) {
            sum -= integer;
        }

        return sum;
    }

}
