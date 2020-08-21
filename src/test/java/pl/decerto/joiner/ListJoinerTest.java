package pl.decerto.joiner;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.decerto.joiner.service.joiner.elementJointer.NumberAdditionElementJoiner;
import pl.decerto.joiner.service.joiner.elementJointer.IntegerSubtractionListJoiner;
import pl.decerto.joiner.service.joiner.NumberListJoiner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListJoinerTest {

    @Test()
    public void testOneListJoin(){
        List<Number> integerChunksFrom1 = new ArrayList<>();
        integerChunksFrom1.add(1);

        HashMap<String, List<Number>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);

        NumberListJoiner numberListJoiner = new NumberListJoiner(stringListHashMap);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberListJoiner.join(NumberAdditionElementJoiner.getInstance());
        });
    }

    @Test
    public void testIntegerAdditionChunksJoin() {
        List<Number> integerChunksFrom1 = new ArrayList<>();
        List<Number> integerChunksFrom2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerChunksFrom1.add(i);
            integerChunksFrom2.add(i);
        }

        HashMap<String, List<Number>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);
        stringListHashMap.put("2", integerChunksFrom2);

        NumberListJoiner numberListJoiner = new NumberListJoiner(stringListHashMap);
        List<Number> joinedList = numberListJoiner.join(NumberAdditionElementJoiner.getInstance());
        assertEquals(joinedList.size(), 10);
        assertEquals(joinedList.get(0), BigDecimal.valueOf(0));
    }

    @Test
    public void testIntegerSubtractionChunksJoin() {

        List<Number> integerChunksFrom1 = new ArrayList<>();
        List<Number> integerChunksFrom2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerChunksFrom1.add(i);
            integerChunksFrom2.add(i);
        }

        HashMap<String, List<Number>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("1", integerChunksFrom1);
        stringListHashMap.put("2", integerChunksFrom2);

        NumberListJoiner numberListJoiner = new NumberListJoiner(stringListHashMap);
        List<Number> joinedList = numberListJoiner.join(IntegerSubtractionListJoiner.getInstance());

        assertEquals(joinedList.size(), 10);
        assertEquals(joinedList.get(0), BigDecimal.valueOf(0));
    }
}
