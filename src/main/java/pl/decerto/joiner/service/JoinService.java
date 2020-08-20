package pl.decerto.joiner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.decerto.joiner.api.JoinMethod;
import pl.decerto.joiner.infratructure.h2.PersonRepo;
import pl.decerto.joiner.service.join.IntegerAdditionElementJoiner;
import pl.decerto.joiner.service.join.IntegerrListJointer;

import java.util.List;
import java.util.Map;

@Service
public class JoinService {

    @Autowired
    private RandomIntegerService randomIntegerService;

    @Autowired
    private PersonRepo personRepo;

    public List<Integer> join(Map<String, List<Integer>> integerlistMap, JoinMethod joinMethod) {

        //@FIXME ADD VISITOR DESIGN PATTERN

        if (joinMethod.equals(JoinMethod.ADDITION)) {
            IntegerrListJointer integerrListJointer = new IntegerrListJointer();
            return integerrListJointer.join(integerlistMap, new IntegerAdditionElementJoiner());
        }

        return null;
    }

}