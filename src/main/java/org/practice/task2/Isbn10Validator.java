package org.practice.task2;

public class Isbn10Validator {
    public boolean isValidISBN (String isbn) {
        if (isbn == null) return false;
        String isbnNoHyphens = isbn.replace("-", "");
        if (isbnNoHyphens.length() != 10) return false;
        int sum = 0;
        int x = 10;
        for (int i = 0; i < 10; i++) {
            if (i == 9 && isbnNoHyphens.charAt(i) == 'X') {
                sum += 10;
            } else {
                if (!Character.isDigit(isbnNoHyphens.charAt(i))) {
                    return false;
                }
                sum += x * Integer.parseInt(String.valueOf(isbnNoHyphens.charAt(i)));
                x--;
            }
         }
        return sum % 11 == 0;
    }
}
