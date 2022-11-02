package com.batch.springbatch.tools;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1, 100 + 1);
    }

    public static Long randomLong() {
        return (long) ThreadLocalRandom.current().nextInt(1, 100 + 1);
    }

}
