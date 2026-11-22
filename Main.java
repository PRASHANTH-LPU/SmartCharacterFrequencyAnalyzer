
import java.util.HashMap;
import java.util.Scanner;

class Main {

    // Method 1: Count character frequency
    static HashMap<Character, Integer> countFrequency(String text) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map;
    }

    // Method 2: Display all frequencies
    static void displayFrequency(HashMap<Character, Integer> map) {
        System.out.println("\nCharacter Frequencies:");

        for (char ch : map.keySet()) {
            if (ch == ' ')
                System.out.println("[space] : " + map.get(ch));
            else
                System.out.println(ch + " : " + map.get(ch));
        }
    }

    // Method 3: Show unique characters
    static void showUnique(HashMap<Character, Integer> map) {
        System.out.println("\nUnique Characters:");

        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                if (ch == ' ')
                    System.out.println("[space]");
                else
                    System.out.println(ch);
            }
        }
    }

    // Method 4: Show repeated characters
    static void showRepeated(HashMap<Character, Integer> map) {
        System.out.println("\nRepeated Characters:");

        for (char ch : map.keySet()) {
            if (map.get(ch) > 1) {
                if (ch == ' ')
                    System.out.println("[space] : " + map.get(ch));
                else
                    System.out.println(ch + " : " + map.get(ch));
            }
        }
    }

    // Method 5: Find the most frequent character
    static void findMostFrequent(HashMap<Character, Integer> map) {

        int max = 0;

        for (char ch : map.keySet()) {
            if (map.get(ch) > max) {
                max = map.get(ch);
            }
        }

        System.out.println("\nMost Frequent Character(s):");

        for (char ch : map.keySet()) {
            if (map.get(ch) == max) {
                if (ch == ' ')
                    System.out.println("[space] : " + max);
                else
                    System.out.println(ch + " : " + max);
            }
        }
    }

    // Method 6: Character statistics
    static void showStatistics(String text) {

        int letters = 0;
        int digits = 0;
        int spaces = 0;
        int special = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch))
                letters++;
            else if (Character.isDigit(ch))
                digits++;
            else if (ch == ' ')
                spaces++;
            else
                special++;
        }

        System.out.println("\nCharacter Statistics:");
        System.out.println("Letters: " + letters);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        System.out.println("Special characters: " + special);
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SMART CHARACTER FREQUENCY ANALYZER =====");
        System.out.print("Enter text: ");

        String text = sc.nextLine().toLowerCase();

        if (text.trim().isEmpty()) {
            System.out.println("Text cannot be empty!");
            sc.close();
            return;
        }

        HashMap<Character, Integer> map = countFrequency(text);

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Character Frequency");
            System.out.println("2. Unique Characters");
            System.out.println("3. Repeated Characters");
            System.out.println("4. Most Frequent Character");
            System.out.println("5. Character Statistics");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayFrequency(map);
                    break;

                case 2:
                    showUnique(map);
                    break;

                case 3:
                    showRepeated(map);
                    break;

                case 4:
                    findMostFrequent(map);
                    break;

                case 5:
                    showStatistics(text);
                    break;

                case 6:
                    System.out.println("Thank you for using the analyzer!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
