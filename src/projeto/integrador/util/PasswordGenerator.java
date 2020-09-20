/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.util;

import java.util.Random;

/**
 *
 * @author Rafael
 */
public class PasswordGenerator {

    private static final char[] ALL_CHARS = new char[62];
    private static final Random RANDOM = new Random();

    static {
        for (int i = 48, j = 0; i < 123; i++) {
            if (Character.isLetterOrDigit(i)) {
                ALL_CHARS[j] = (char) i;
                j++;
            }
        }
    }

    public static String getRandomPassword(final int length) {
        final char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = ALL_CHARS[RANDOM.nextInt(ALL_CHARS.length)];
        }
        return new String(result).toUpperCase();
    }

    public static String getRandomPassword() {
        return getRandomPassword(8);
    }

    private PasswordGenerator() {
    }
}
