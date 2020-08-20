package pl.decerto.joiner;


import org.junit.jupiter.api.Test;
import pl.decerto.joiner.service.join.IntegerAdditionElementJoiner;
import pl.decerto.joiner.service.join.IntegerSubtractionListJoiner;
import pl.decerto.joiner.service.join.IntegerrListJointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DecertoTest {

    @Test
    public void testCAdditionChunks() {
        IntegerrListJointer integerrListJointer = new IntegerrListJointer();


        List<Integer> integerChunksFrom1 = new ArrayList<>();
        List<Integer> integerChunksFrom2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerChunksFrom1.add(i);
            integerChunksFrom2.add(i);
        }

        HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);
        stringListHashMap.put("2", integerChunksFrom2);

        List<Integer> join = integerrListJointer.join(stringListHashMap, new IntegerAdditionElementJoiner());
    }

    @Test
    public void testSubtractionChunks() {
        IntegerrListJointer integerrListJointer = new IntegerrListJointer();


        List<Integer> integerChunksFrom1 = new ArrayList<>();
        List<Integer> integerChunksFrom2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerChunksFrom1.add(i);
            integerChunksFrom2.add(i);
        }

        HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);
        stringListHashMap.put("2", integerChunksFrom2);

        List<Integer> join = integerrListJointer.join(stringListHashMap, new IntegerSubtractionListJoiner());
    }
}
