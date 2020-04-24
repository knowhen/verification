package org.when.verification.domain;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author: when
 * @create: 2020-04-23  16:27
 **/
public class RandomCodeGenerator implements CodeGenerator {
    /**
     * The alphanumeric characters
     */
    static final char[] ALPHANUM = "0123456789".toCharArray();
    private final Random random;

    public RandomCodeGenerator() {
        this(new SecureRandom());
    }

    public RandomCodeGenerator(Random random) {
        this.random = random;
    }

    @Override
    public String generate(int length) {
        if(length <=0) {
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder(length);
        while (result.length() < length) {
            int index = random.nextInt(ALPHANUM.length);
            result.append(ALPHANUM[index]);
        }
        return result.toString();
    }
}
