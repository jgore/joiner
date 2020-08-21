package pl.decerto.joiner.service.joiner;

import pl.decerto.joiner.service.joiner.elementJointer.ElementJoiner;

import java.util.List;

public interface ListJoiner<Chunk> {
    List<Chunk> join( ElementJoiner<Chunk> elementJoiner);

}
