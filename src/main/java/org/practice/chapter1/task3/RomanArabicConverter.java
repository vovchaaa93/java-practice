package org.practice.chapter1.task3;


public class RomanArabicConverter {

    private static final String[] ROMAN_NUMERALS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    private final static int[] DECIMAL_VALUES = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public int romanToArabic (String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new RuntimeException("Not roman");
        }
        roman = roman.toUpperCase();
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            if ("IVXLCDM".indexOf(c) == -1) {
                throw new RuntimeException("Not roman");
            }
        }
        int result = 0;
        for (int i = 0; i < ROMAN_NUMERALS.length; i++) {
            String romanNumeral = ROMAN_NUMERALS[i];
            int decimalValue = DECIMAL_VALUES[i];
            while (roman.startsWith(romanNumeral)) {
                result += decimalValue;
                roman = roman.substring(romanNumeral.length());
            }
        }
        return result;
    }

    public String arabicToRoman (int arabic) {
        if (arabic > 3999 || arabic < 1) {
            throw new RuntimeException("Arabic must be 1-3999");
        }
        StringBuilder result = new StringBuilder();
        int remaining = arabic;
        for (int i = 0; i < ROMAN_NUMERALS.length; i++) {
            int decimalValue = DECIMAL_VALUES[i];
            String romanNumeral = ROMAN_NUMERALS[i];
            while (remaining >= decimalValue) {
                result.append(romanNumeral);
                remaining -= decimalValue;
            }
        }
        return result.toString();
    }

}
