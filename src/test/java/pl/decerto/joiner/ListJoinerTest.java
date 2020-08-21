package pl.decerto.joiner;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.decerto.joiner.service.joiner.elementJointer.IntegerAdditionElementJoiner;
import pl.decerto.joiner.service.joiner.elementJointer.IntegerSubtractionListJoiner;
import pl.decerto.joiner.service.joiner.IntegerListJoiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListJoinerTest {

    @Test()
    public void testOneListJoin(){
        List<Integer> integerChunksFrom1 = new ArrayList<>();
        integerChunksFrom1.add(1);

        HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);

        IntegerListJoiner integerListJoiner = new IntegerListJoiner(stringListHashMap);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integerListJoiner.join(IntegerAdditionElementJoiner.getInstance());
        });
    }

    @Test
    public void testAdditionChunksJoin() {
        List<Integer> integerChunksFrom1 = new ArrayList<>();
        List<Integer> integerChunksFrom2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerChunksFrom1.add(i);
            integerChunksFrom2.add(i);
        }

        HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);
        stringListHashMap.put("2", integerChunksFrom2);

        IntegerListJoiner integerListJoiner = new IntegerListJoiner(stringListHashMap);
        List<Integer> joinedList = integerListJoiner.join(IntegerAdditionElementJoiner.getInstance());
        assertEquals(joinedList.size(), 10);
        assertEquals(joinedList.get(0), 0);
    }

    @Test
    public void testSubtractionChunksJoin() {

        List<Integer> integerChunksFrom1 = new ArrayList<>();
        List<Integer> integerChunksFrom2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerChunksFrom1.add(i);
            integerChunksFrom2.add(i);
        }

        HashMap<String, List<Integer>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);
        stringListHashMap.put("2", integerChunksFrom2);

        IntegerListJoiner integerListJoiner = new IntegerListJoiner(stringListHashMap);
        List<Integer> joinedList = integerListJoiner.join(IntegerSubtractionListJoiner.getInstance());

        assertEquals(joinedList.size(), 10);
        assertEquals(joinedList.get(0), 0);
    }
}
