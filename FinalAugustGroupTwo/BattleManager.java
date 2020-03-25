package com.company.Exams.FinalAugustGroupTwo;

import java.util.*;

public class BattleManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> result = new HashMap<>();

        String input = sc.nextLine();
        while (!"Results".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            if (command.equals("Add")) {
                String personName = tokens[1];
                int health = Integer.parseInt(tokens[2]);
                int energy = Integer.parseInt(tokens[3]);

                if (!result.containsKey(personName)) {
                    result.put(personName, new ArrayList<>());
                    result.get(personName).add(0, health);
                    result.get(personName).add(1, energy);
                } else {
                    result.get(personName).set(0, health + result.get(personName).get(0));
                }
            } else if (command.equals("Attack")) {
                String attackerName = tokens[1];
                String defenderName = tokens[2];
                int damage = Integer.parseInt(tokens[3]);

                if (result.containsKey(attackerName) && result.containsKey(defenderName)) {
                    result.get(defenderName).set(0, result.get(defenderName).get(0) - damage);
                    if (0 >= result.get(defenderName).get(0)) {
                        result.remove(defenderName);
                        System.out.printf("%s was disqualified!%n", defenderName);
                    }

                    result.get(attackerName).set(1, result.get(attackerName).get(1) - 1);
                    if (0 >= result.get(attackerName).get(1)) {
                        result.remove(attackerName);
                        System.out.printf("%s was disqualified!%n", attackerName);
                    }
                }
            } else if (command.equals("Delete")) {
                String name = tokens[1];

                if (name.equals("All")) {
                    result.clear();
                } else {
                    result.remove(name);
                }
            }

            input = sc.nextLine();
        }
        System.out.printf("People count: %d%n", result.size());
        result.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    if (p1.getValue().get(0) == p2.getValue().get(0)) {
                        return p1.getKey().compareTo(p2.getKey());
                    }
                    return p2.getValue().get(0) - p1.getValue().get(0);
                })
                .forEach(p -> {
                    System.out.printf("%s - %d - %d%n", p.getKey(), p.getValue().get(0), p.getValue().get(1));
                });
    }
}
