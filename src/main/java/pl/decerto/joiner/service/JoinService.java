package pl.decerto.joiner.service;

import org.springframework.stereotype.Service;
import pl.decerto.joiner.service.joiner.elementJointer.ElementJoiner;
import pl.decerto.joiner.service.joiner.NumberListJoiner;

import java.util.List;
import java.util.Map;

@Service
public class JoinService {

    public List<Number> join(Map<String, List<Number>> integerListMap, ElementJoiner<Number> elementJoiner) {

        NumberListJoiner numberListJoiner = new NumberListJoiner(integerListMap);
        numberListJoiner.join(elementJoiner);

        return numberListJoiner.getResultList();

    }

}
