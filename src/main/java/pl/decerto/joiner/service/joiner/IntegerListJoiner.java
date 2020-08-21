package pl.decerto.joiner.service.joiner;

import java.util.List;
import java.util.Map;

public class IntegerListJoiner extends AbstractListJoiner<Integer> {

    public IntegerListJoiner(Map<String, List<Integer>> chunkMap) {
        super(chunkMap);
    }

}
