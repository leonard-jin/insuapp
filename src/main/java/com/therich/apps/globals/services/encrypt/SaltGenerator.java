package com.therich.apps.globals.services.encrypt;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * Created by kh.jin on 2020. 2. 25.
 */
public class SaltGenerator {

    // TODO : encoder 속으로....

    private final static int DEFAULT_LENGTH = 10;

    public static String generate() {
        return SaltGenerator.generate(DEFAULT_LENGTH);
    }

    public static String generate(int len) {
        byte[] array = new byte[len];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}
