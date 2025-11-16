package org.practice.task3;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanArabicConverterTest {

    private final RomanArabicConverter converter = new RomanArabicConverter();

    @Test
    void testRomanToArabic() {
        assertEquals(14, converter.romanToArabic("XIV"));
        assertEquals(1990, converter.romanToArabic("MCMXC"));
        assertEquals(49, converter.romanToArabic("XLIX"));
    }

    @Test
    void testArabicToRoman() {
        assertEquals("XLIX", converter.arabicToRoman(49));
        assertEquals("MMXXIII", converter.arabicToRoman(2023));
        assertEquals("CDXLIV", converter.arabicToRoman(444));
    }

    @Test
    void testEdgeCases() {
        assertEquals("I", converter.arabicToRoman(1));
        assertEquals("MMMCMXCIX", converter.arabicToRoman(3999));
    }

}