package pl.decerto.joiner.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomIntegerService {
    private Random random = new Random();

    public List<Number> generate(Integer size) {
        List<Number> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextDouble());
        }
        return list;
    }
}
