package com.company.Exams.FinalJuly;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^(?<artist>[A-Z][a-z'\\s]+):(?<song>[A-Z\\s]+)$");

        String input = sc.nextLine();
        while (!"end".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String artist = matcher.group("artist");
                int key = artist.length();
                String song = matcher.group("song");

                System.out.printf("Successful encryption: %s@%s%n", encryptText(artist, key), encryptText(song, key));
            } else {
                System.out.printf("Invalid input!%n");
            }

            input = sc.nextLine();
        }
    }

    private static String encryptText(String text, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            char replacement = letter;
            if (letter != '\'' &&  letter != ' ') {
                replacement = (char) (letter + key);
                if (letter <= 90 && replacement > 90) {
                    replacement = (char) (65 + (key - (91 - letter)));
                }
                if (letter <= 122 && replacement > 122) {
                    replacement = (char) (97 + (key - (123 - letter)));
                }
            }
            sb.append(replacement);
        }
        return sb.toString();
    }
}
