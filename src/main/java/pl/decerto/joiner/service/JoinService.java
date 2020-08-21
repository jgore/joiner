package pl.decerto.joiner.service;

import org.springframework.stereotype.Service;
import pl.decerto.joiner.service.joiner.elementJointer.ElementJoiner;
import pl.decerto.joiner.service.joiner.elementJointer.IntegerAdditionElementJoiner;
import pl.decerto.joiner.service.joiner.IntegerListJoiner;

import java.util.List;
import java.util.Map;

@Service
public class JoinService {

    public List<Integer> join(Map<String, List<Integer>> integerListMap, ElementJoiner<Integer> elementJoiner) {

        IntegerListJoiner integerListJoiner = new IntegerListJoiner(integerListMap);
        integerListJoiner.join(elementJoiner);

        return integerListJoiner.getResultList();

    }

}
