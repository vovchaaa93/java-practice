# Задача 1.4: ГЕНЕРАТОР ПАРОЛЕЙ

## Описание
Напишите универсальный генератор паролей с настраиваемыми параметрами.

## Требования
- **Метод**: String generatePassword (int length, boolean useDigits, boolean useLowercase,
  boolean useUppercase, boolean useSpecialChars);

## Параметры:
- length: длина пароля (8-64)
- useDigits: использовать цифры 0-9
- useLowercase: использовать буквы a-z
- useUppercase: использовать буквы A-Z
- useSpecialChars: использовать спецсимволы !@#$%^&*()_+-=

## Правила:

- Минимум один символ из каждой выбранной категории
- Случайное перемешивание символов
- Бросить исключение при невалидных параметрах

## Примеры
```java
generatePassword(12, true, true, true, false) 
// → "Ax8rTp9qLm2N" (только цифры и буквы)

generatePassword(10, true, true, false, true)
// → "k3@m#p9$t!" (нет заглавных)

generatePassword(8, false, true, true, true)
// → "aB@dF#gH" (нет цифр)