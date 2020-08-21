package pl.decerto.joiner.service.joiner;

import java.util.List;
import java.util.Map;

public class NumberListJoiner extends AbstractListJoiner<Number> {

    public NumberListJoiner(Map<String, List<Number>> chunkMap) {
        super(chunkMap);
    }

}
