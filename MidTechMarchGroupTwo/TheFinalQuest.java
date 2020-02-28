package com.company.Exams.MidTechMarchGroupTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split("\\s+");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(array));

        String input = sc.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if ("Delete".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                if (indexValidator(words, index + 1)) {
                    words.remove(index + 1);
                }
            } else if ("Swap".equals(command)) {
                String firstWord = tokens[1];
                String secondWord = tokens[2];
                if (wordsValidator(words, firstWord, secondWord)) {
                    swapWords(words, firstWord, secondWord);
                }
            } else if ("Put".equals(command)) {
                String word = tokens[1];
                int index = Integer.parseInt(tokens[2]);
                if (indexValidator(words, index - 1)) {
                    words.add(index - 1, word);
                } else if (index - 1 == words.size()) {
                    words.add(word);
                }
            } else if ("Sort".equals(command)) {
                words = (ArrayList<String>) words.stream().sorted((s1, s2)-> s2.compareTo(s1)).collect(Collectors.toList());
            } else if ("Replace".equals(command)) {
                String replacement = tokens[1];
                String toBeReplaced = tokens[2];
                if (words.contains(toBeReplaced)) {
                    int index = words.indexOf(toBeReplaced);
                    words.set(index, replacement);
                }
            }

            input = sc.nextLine();
        }
        String result = String.join(" ", words);
        System.out.println(result);
    }

    private static void swapWords(ArrayList<String> words, String firstWord, String secondWord) {
        int firstIndex = words.indexOf(firstWord);
        int secondIndex = words.indexOf(secondWord);
        words.set(firstIndex, secondWord);
        words.set(secondIndex, firstWord);
    }

    private static boolean wordsValidator(ArrayList<String> words, String firstWord, String secondWord) {
        return (words.contains(firstWord) && words.contains(secondWord));
    }

    private static boolean indexValidator(ArrayList<String> list, int index) {
        return (index >= 0 && index < list.size());
    }
}
