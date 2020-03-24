package com.company.Exams.FinalDecemberGroupTwo;

import java.util.*;

public class NikuldensMeals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int dislikedMeals = 0;
        Map<String, Set<String>> record = new HashMap<>();

        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];

            if (command.equals("Like")) {
                record.putIfAbsent(guest, new HashSet<>());
                record.get(guest).add(meal);
            } else if (command.equals("Unlike")) {
                if (record.containsKey(guest)) {
                    if (record.get(guest).contains(meal)) {
                        record.get(guest).remove(meal);
                        dislikedMeals++;
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                    } else {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    }
                } else {
                    System.out.printf("%s is not at the party.%n", guest);
                }
            }

            input = sc.nextLine();
        }

        record.entrySet()
                .stream()
                .sorted((g1, g2) -> {
                    if (g1.getValue().size() == g2.getValue().size()) {
                        return g1.getKey().compareTo(g2.getKey());
                    }
                    return g2.getValue().size() - g1.getValue().size();
                })
                .forEach(g -> System.out.printf("%s: %s%n", g.getKey(), String.join(", ", g.getValue())));
        System.out.printf("Unliked meals: %d", dislikedMeals);
    }
}
