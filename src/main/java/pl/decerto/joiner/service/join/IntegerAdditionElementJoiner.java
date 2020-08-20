package pl.decerto.joiner.service.join;

import java.util.List;

public class IntegerAdditionElementJoiner implements ElementJoiner<Integer> {

    @Override
    public Integer join(List<Integer> ints) {
        return ints.stream()
                .mapToInt(x -> x)
                .sum();
    }
}
