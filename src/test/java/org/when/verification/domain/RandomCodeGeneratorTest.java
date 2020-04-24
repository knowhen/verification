package org.when.verification.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RandomCodeGeneratorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private RandomCodeGenerator generator = new RandomCodeGenerator();

    @Test
    public void testGenerateRandomAlphanum() {
        int length = 4;
        String alphanumStr = generator.generate(length);
        assertNotNull(alphanumStr);
        assertEquals(length, alphanumStr.length());
        for (char c : alphanumStr.toCharArray()) {
            assertTrue('0' <= c && c <= '9');
        }
    }

    @Test
    public void testGenerateRandomAlphanum_lengthEqualsOrLessThanZero() {
        exception.expect(IllegalArgumentException.class);
        String alphanumStr = generator.generate(-1);
    }
}