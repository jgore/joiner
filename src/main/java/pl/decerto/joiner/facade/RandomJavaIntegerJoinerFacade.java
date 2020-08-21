package pl.decerto.joiner.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.decerto.joiner.service.JoinService;
import pl.decerto.joiner.service.RandomIntegerService;
import pl.decerto.joiner.service.joiner.elementJointer.ElementJoiner;

import java.util.HashMap;
import java.util.List;

@Service
public class RandomJavaIntegerJoinerFacade {

    @Autowired
    private RandomIntegerService randomIntegerService;

    @Autowired
    private JoinService joinService;

    public List<Integer> join(ElementJoiner<Integer> elementJoiner) {

        List<Integer> generateList1 = randomIntegerService.generate(100);
        List<Integer> generateList2 = randomIntegerService.generate(100);
        List<Integer> generateList3 = randomIntegerService.generate(100);

        HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("randomJava1", generateList1);
        stringListHashMap.put("randomJava2", generateList2);
        stringListHashMap.put("randomJava3", generateList2);

        return joinService.join(stringListHashMap, elementJoiner);

    }


}
