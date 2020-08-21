package pl.decerto.joiner.service.joiner.elementJointer;

import java.util.List;

public interface ElementJoiner<ELEMENT>  {
    ELEMENT join(List<ELEMENT> elements);
}
