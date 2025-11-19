package org.practice.chapter1.task4;

import org.junit.jupiter.api.Test;
import org.practice.chapter1.task4.PasswordGenerator;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    private final PasswordGenerator generator = new PasswordGenerator();

    @Test
    void testAllCharacterTypes() {
        String password = generator.generatePassword(12, true, true, true, true);
        assertTrue(password.matches(".*[0-9].*")); // содержит цифру
        assertTrue(password.matches(".*[a-z].*")); // содержит маленькую букву
        assertTrue(password.matches(".*[A-Z].*")); // содержит большую букву
        assertTrue(password.matches(".*[!@#$%^&*()_+=].*")); // содержит спецсимвол
    }

    @Test
    void testOnlyDigitsAndLetters() {
        String password = generator.generatePassword(10, true, true, true, false);
        assertTrue(password.matches("^[a-zA-Z0-9]{10}$")); // только буквы и цифры
    }

    @Test
    void testInvalidLength() {
        assertThrows(IllegalArgumentException.class, () ->
                generator.generatePassword(7, true, true, false, false));
    }

    @Test
    void testNoConditionsSelected() {
        assertThrows(IllegalArgumentException.class, () ->
                generator.generatePassword(10, false, false, false, false));
    }

}