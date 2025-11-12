# Задача 1: Поиск самого длинного палиндрома

## Описание
Найти самую длинную подстроку-палиндром в заданной строке.

## Требования
- **Метод:** `String findLongestPalindrome(String str)`
- **Возврат:** пустая строка "" если палиндромов нет
- **Приоритет:** первый встреченный палиндром при равенстве длин
- **Регистр:** учитывается

## Примеры
```java
findLongestPalindrome("babad") → "bab" (или "aba")
findLongestPalindrome("cbbd") → "bb"
findLongestPalindrome("abc") → ""
findLongestPalindrome("a") → "a"