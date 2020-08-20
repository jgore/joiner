package pl.decerto.joiner.service.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractListJoiner<Chunk> implements ListJoiner<Chunk> {


    @Override
    public List<Chunk> join(Map<String, List<Chunk>> chunkMap, ElementJoiner<Chunk> elementJoiner) {


        List<List<Chunk>> chunkListOfLists = new ArrayList<>(chunkMap.values());
        List<Chunk> resultList = new ArrayList<>();

        Chunk lastElement = null;
        for (int i = 0; i < chunkListOfLists.get(0).size(); i++) {
            List<Chunk> oneRowChunks = new ArrayList<>();
            List<Chunk> chunks = new ArrayList<>();
            for (int j = 0; j < chunkListOfLists.size(); j++) {

                chunks = chunkListOfLists.get(j);
                oneRowChunks.add(chunks.get(i));
            }
            Chunk joinedChunk = elementJoiner.join(oneRowChunks);
            resultList.add(joinedChunk);
        }

        return resultList;
    }
}
