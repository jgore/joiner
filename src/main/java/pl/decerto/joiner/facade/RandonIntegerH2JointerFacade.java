package pl.decerto.joiner.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.decerto.joiner.api.JoinMethod;
import pl.decerto.joiner.domain.model.Person;
import pl.decerto.joiner.infratructure.h2.PersonRepo;
import pl.decerto.joiner.service.JoinService;
import pl.decerto.joiner.service.RandomIntegerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RandonIntegerH2JointerFacade {

    @Autowired
    private RandomIntegerService randomIntegerService;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private JoinService joinService;

    public List<Integer> join(JoinMethod joinMethod) {

        if (JoinMethod.ADDITION.equals(joinMethod)) {
            List<Integer> generateList = randomIntegerService.generate(10);
            Iterable<Person> all = personRepo.findAll();

            List<Integer> alls = new ArrayList<>();
            all.iterator().forEachRemaining(e -> {
                alls.add(e.getAge());
            });

            HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
            stringListHashMap.put("random", generateList);
            stringListHashMap.put("h2", alls);

            return joinService.join(stringListHashMap, JoinMethod.ADDITION);
        } else {
            throw new IllegalArgumentException("only addition join method is allowed yet");
        }

    }


}
