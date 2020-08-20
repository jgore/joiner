package pl.decerto.joiner.service;


import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomIntegerService {
    private Random random = new Random();

    public Integer generate() {
        return random.nextInt(100);
    }
}
