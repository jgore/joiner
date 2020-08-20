package pl.decerto.joiner.service.join;

import java.util.List;
import java.util.Map;

public interface ListJoiner<Chunk> {
    List<Chunk> join(Map<String, List<Chunk>> chunkMap, ElementJoiner<Chunk> elementJoiner);
}
