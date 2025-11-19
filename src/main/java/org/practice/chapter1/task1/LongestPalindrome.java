package org.practice.chapter1.task1;

public class LongestPalindrome {

    public String findLongestPalindrome(String string) {
        if (string.length() <= 1) return string;
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            String palindromeOdd = expandFromCenter(string, i, i);
            String palindromeEven = expandFromCenter(string, i, i+1);

            if (palindromeOdd.length() > result.length() && palindromeOdd.length() > 1) {
                result = palindromeOdd;
            }
            if (palindromeEven.length() > result.length()) {
                result = palindromeEven;
            }
        }
        return result.isEmpty() ? "" : result;
    }

    private String expandFromCenter(String string, int left, int right) {
        while (left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)) {
            left--;
            right++;
        }
        return string.substring(left + 1, right);
    }
}
