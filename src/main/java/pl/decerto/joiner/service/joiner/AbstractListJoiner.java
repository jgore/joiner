package pl.decerto.joiner.service.joiner;

import pl.decerto.joiner.service.joiner.elementJointer.ElementJoiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractListJoiner<Chunk> implements ListJoiner<Chunk> {

    private Map<String, List<Chunk>> chunkMap;
    private List<Chunk> resultList = new ArrayList<>();

    public AbstractListJoiner(Map<String, List<Chunk>> chunkMap) {
        this.chunkMap = chunkMap;
    }

    @Override
    public List<Chunk> join(ElementJoiner<Chunk> elementJoiner) {

        //@FIXME move to constructor
        if(elementJoiner == null){
            throw new IllegalArgumentException("element joiner cannot be null");
        }

        //@FIXME move to constructor
        if (chunkMap.size() < 2) {
            throw new IllegalArgumentException("chunk map be less than 2");
        }

        List<List<Chunk>> chunkListOfLists = new ArrayList<>(chunkMap.values());

        int size = chunkListOfLists.get(0).size();

        chunkListOfLists.forEach(list -> {
            if (list.size() != size) {
                throw new IllegalArgumentException("All lists need to have the same size to join them");
            }
        });

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

    public List<Chunk> getResultList() {
        return new ArrayList<>(resultList);
    }
}
