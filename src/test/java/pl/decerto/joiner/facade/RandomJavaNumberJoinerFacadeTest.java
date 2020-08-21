package pl.decerto.joiner.facade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.decerto.joiner.service.joiner.elementJointer.NumberAdditionElementJoiner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RandomJavaNumberJoinerFacadeTest {

    @Autowired
    private RandomJavaNumberJoinerFacade randomJavaNumberJoinerFacade;

    @Test
    void join() {
        List<Number> joinedList = randomJavaNumberJoinerFacade.join(NumberAdditionElementJoiner.getInstance());
        assertEquals(joinedList.size(), 100);
    }
}