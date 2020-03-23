package com.company.Exams.FinalDecember;

import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> wizards = new HashMap<>();

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "Enroll":
                    if (!wizards.containsKey(heroName)) {
                        wizards.put(heroName, new ArrayList<>());
                    } else {
                        System.out.printf("%s is already enrolled.%n", heroName);
                    }
                    break;
                case "Learn":
                    String spellName = tokens[2];
                    if (!wizards.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    } else {
                        if (!wizards.get(heroName).contains(spellName)) {
                            wizards.get(heroName).add(spellName);
                        } else {
                            System.out.printf("%s has already learnt %s.%n", heroName, spellName);
                        }
                    }
                    break;
                case "Unlearn":
                    String spellNameToRemove = tokens[2];
                    if (!wizards.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    } else {
                        if (!wizards.get(heroName).contains(spellNameToRemove)) {
                            System.out.printf("%s doesn't know %s.%n", heroName, spellNameToRemove);
                        } else {
                            wizards.get(heroName).remove(spellNameToRemove);
                        }
                    }
                    break;
            }

            input = sc.nextLine();
        }
        System.out.println("Heroes:");
        wizards.entrySet()
                .stream()
                .sorted((w1, w2) -> {
                    if (w1.getValue().size() == w2.getValue().size()) {
                        String first = w1.getKey();
                        String second = w2.getKey();
                        return first.compareTo(second);
                    }
                    return w2.getValue().size() - w1.getValue().size();
                })
                .forEach(w -> {
                    System.out.printf("== %s:", w.getKey());
                    System.out.print(" " + String.join(", ", w.getValue()));;
                    System.out.println();
                });
    }
}
