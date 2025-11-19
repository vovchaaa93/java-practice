package org.practice.chapter1.task2;

import org.junit.jupiter.api.Test;
import org.practice.chapter1.task2.Isbn10Validator;

import static org.junit.jupiter.api.Assertions.*;

class Isbn10ValidatorTest {

    private final Isbn10Validator validator = new Isbn10Validator();

    @Test
    void testValidISBNWithHyphens() {
        assertTrue(validator.isValidISBN("0-306-40615-2"));
    }

    @Test
    void testValidISBNWithoutHyphens() {
        assertTrue(validator.isValidISBN("0306406152"));
    }

    @Test
    void testValidISBNWithX() {
        assertTrue(validator.isValidISBN("1-234-56789-X"));
    }

    @Test
    void testInvalidISBNWrongCheckDigit() {
        assertFalse(validator.isValidISBN("0-306-40615-9"));
    }

    @Test
    void testInvalidISBNTooShort() {
        assertFalse(validator.isValidISBN("123"));
        assertFalse(validator.isValidISBN(""));
    }

    @Test
    void testInvalidISBNTooLong() {
        assertFalse(validator.isValidISBN("12345678901"));
    }

    @Test
    void testInvalidISBNWithInvalidCharacters() {
        assertFalse(validator.isValidISBN("123456789Y"));
        assertFalse(validator.isValidISBN("1A3-456-789"));
    }

    @Test
    void testInvalidISBNWithXInWrongPosition() {
        assertFalse(validator.isValidISBN("X-306-40615-2"));
        assertFalse(validator.isValidISBN("0-306-4061X-2"));
    }

    @Test
    void testEdgeCaseSingleDigit() {
        assertFalse(validator.isValidISBN("1"));
    }

    @Test
    void testNullInput() {
        assertFalse(validator.isValidISBN(null));
    }

    @Test
    void testValidRealWorldExamples() {
        assertTrue(validator.isValidISBN("0596009208"));
        assertTrue(validator.isValidISBN("0321356683"));
    }
}