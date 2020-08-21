package pl.decerto.joiner.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.decerto.joiner.service.JoinService;
import pl.decerto.joiner.service.RandomIntegerService;
import pl.decerto.joiner.service.joiner.elementJointer.ElementJoiner;

import java.util.HashMap;
import java.util.List;

@Service
public class RandomJavaNumberJoinerFacade {

    @Autowired
    private RandomIntegerService randomIntegerService;

    @Autowired
    private JoinService joinService;

    public List<Number> join(ElementJoiner<Number> elementJoiner) {

        List<Number> generateList1 = randomIntegerService.generate(100);
        List<Number> generateList2 = randomIntegerService.generate(100);
        List<Number> generateList3 = randomIntegerService.generate(100);

        HashMap<String, List<Number>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("randomJava1", generateList1);
        stringListHashMap.put("randomJava2", generateList2);
        stringListHashMap.put("randomJava3", generateList3);

        return joinService.join(stringListHashMap, elementJoiner);

    }


}
