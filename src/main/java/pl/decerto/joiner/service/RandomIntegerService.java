package pl.decerto.joiner.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomIntegerService {
    private Random random = new Random();

    public List<Integer> generate(Integer size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }
}
