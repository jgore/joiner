package pl.decerto.joiner.service.join;

import java.util.List;

public interface ElementJoiner<ELEMENT> {
    ELEMENT join(List<ELEMENT> elements);
}
