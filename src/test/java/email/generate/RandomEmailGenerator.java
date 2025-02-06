package email.generate;

import java.util.Random;

public class RandomEmailGenerator {

    // Метод для генерации случайной почты
    public static String generateRandomEmail() {
        int localPartLength = getRandomLength(3, 12); // Длина первой части почты (от 3 до 12 символов)

        String[] tlds = { ".ru", ".com", ".org" }; // Список доступных доменных зон
        String tld = tlds[new Random().nextInt(tlds.length)]; // Случайный выбор доменной зоны
        String[] domainParts = { "yandex", "mail", "yahoo" };
        String domainPart = domainParts[new Random().nextInt(domainParts.length)];

        String email = generateRandomString(localPartLength) + "@" + domainPart + tld;
        return email;
    }

    // Метод для генерации случайной строки заданной длины
    private static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    // Метод для получения случайной длины в диапазоне от min до max
    private static int getRandomLength(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min; // Генерирует число в диапазоне от min до max
    }

    public static void main(String[] args) {
        // Пример использования
        System.out.println(generateRandomEmail());
    }
}

