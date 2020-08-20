package pl.decerto.joiner.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.decerto.joiner.api.JoinMethod;
import pl.decerto.joiner.api.RandomApi;
import pl.decerto.joiner.domain.model.Person;
import pl.decerto.joiner.service.JoinService;
import pl.decerto.joiner.service.RandomIntegerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RandomJavaIntegerApiRandomJoinerFacade {

    @Autowired
    private RandomIntegerService randomIntegerService;

    @Autowired
    private RandomApi randomApi;

    @Autowired
    private JoinService joinService;

    public List<Integer> join(JoinMethod joinMethod) {

        if (JoinMethod.ADDITION.equals(joinMethod)) {
            List<Integer> generateList = randomIntegerService.generate(10);
            List<Integer> randomApiIntList = randomApi.getRandom(10);
            HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
            stringListHashMap.put("randomJava", generateList);
            stringListHashMap.put("randomAPI", randomApiIntList);

            return joinService.join(stringListHashMap, JoinMethod.ADDITION);
        } else {
            throw new IllegalArgumentException("only addition join method is allowed yet");
        }

    }


}
