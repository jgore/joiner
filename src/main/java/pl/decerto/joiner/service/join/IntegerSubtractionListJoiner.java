package pl.decerto.joiner.service.join;

import java.util.List;

public class IntegerSubtractionListJoiner implements ElementJoiner<Integer> {

    @Override
    public Integer join(List<Integer> ints) {
        int sum = 0;
        for (Integer integer : ints) {
            sum -= integer;
        }

        return sum;
    }

}
