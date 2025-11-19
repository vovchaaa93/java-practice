package org.practice.chapter1.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.practice.chapter1.task1.LongestPalindrome;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    LongestPalindrome longestPalindrome;

    @BeforeEach
    void setUp() {
        longestPalindrome = new LongestPalindrome();
    }

    @Test
    void testNormalCases() {
        assertEquals("bab", longestPalindrome.findLongestPalindrome("babad"));
        assertEquals("bb", longestPalindrome.findLongestPalindrome("cbbd"));
    }

    @Test
    void testEdgeCases() {
        assertEquals("", longestPalindrome.findLongestPalindrome("abc"));
        assertEquals("a", longestPalindrome.findLongestPalindrome("a"));
    }

    @Test
    void testCaseSensitivity() {
        assertEquals("", longestPalindrome.findLongestPalindrome("Aba"));
    }
}