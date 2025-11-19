package org.practice.chapter1.task4;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private final SecureRandom random = new SecureRandom();
    private final String digits = "0123456789";
    private final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String specialChars = "!@#$%^&*()_+-=";

    public String generatePassword(int length, boolean useDigits, boolean useLowerCase,
                                   boolean useUpperCase, boolean useSpecialChars) {

        validateParameters(length, useDigits, useLowerCase, useUpperCase, useSpecialChars);

        StringBuilder password = addRequiredCharacters(useDigits, useLowerCase, useUpperCase, useSpecialChars);
        StringBuilder allSymbols = buildSymbolsPool(useDigits, useLowerCase, useUpperCase, useSpecialChars);
        completePassword(password, allSymbols, length);

        return shufflePassword(password.toString());
    }

    private void validateParameters(int length, boolean useDigits, boolean useLowerCase,
                                    boolean useUpperCase, boolean useSpecialChars) {
        if (length < 8 || length > 64) {
            throw new IllegalArgumentException("Password length must be between 8 and 64 characters");
        }

        if (!useDigits && !useLowerCase && !useUpperCase && !useSpecialChars) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }
    }

    private StringBuilder addRequiredCharacters(boolean useDigits, boolean useLowerCase,
                                       boolean useUpperCase, boolean useSpecialChars) {

        StringBuilder stringBuilder = new StringBuilder();
        if (useDigits) {
            stringBuilder.append(digits.charAt(random.nextInt(digits.length())));
        }
        if (useLowerCase) {
            stringBuilder.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        }
        if (useUpperCase) {
            stringBuilder.append(upperCase.charAt(random.nextInt(upperCase.length())));
        }
        if (useSpecialChars) {
            stringBuilder.append(specialChars.charAt(random.nextInt(specialChars.length())));
        }
        return stringBuilder;
    }

    private StringBuilder buildSymbolsPool (boolean useDigits, boolean useLowerCase,
                                  boolean useUpperCase, boolean useSpecialChars) {

        StringBuilder stringBuilder = new StringBuilder();

        if (useDigits) {
            stringBuilder.append(digits);
        }
        if (useLowerCase) {
            stringBuilder.append(lowerCase);
        }
        if (useUpperCase) {
            stringBuilder.append(upperCase);
        }
        if (useSpecialChars) {
            stringBuilder.append(specialChars);
        }
        return stringBuilder;
    }

    private void completePassword(StringBuilder password, StringBuilder allSymbols, int targetLength) {
        while (password.length() < targetLength) {
            password.append(allSymbols.charAt(random.nextInt(allSymbols.length())));
        }
    }

    private String shufflePassword(String password) {
        List<Character> characters = new ArrayList<>();
        for (char c : password.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters, random);

        StringBuilder shuffled = new StringBuilder();
        for (char c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }
}