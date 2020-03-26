package com.company.Exams.FinalJuly;

import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> bands = new LinkedHashMap<>();
        Map<String, Integer> playtime = new HashMap<>();

        String input = sc.nextLine();
        while (!"start of concert".equals(input)) {
            String[] tokens = input.split("; ");
            String command = tokens[0];
            String bandName = tokens[1];

            if (command.equals("Add")) {
                String[] membersNames = tokens[2].split(", ");
                bands.putIfAbsent(bandName, new LinkedHashSet<>());
                addMembers(bandName, membersNames, bands);
            } else if (command.equals("Play")) {
                int time = Integer.parseInt(tokens[2]);
                playtime.putIfAbsent(bandName, 0);
                playtime.put(bandName, playtime.get(bandName) + time);
            }

            input = sc.nextLine();
        }

        playtime.values()
                .stream()
                .reduce((x, y) -> x + y)
                .ifPresent(b -> System.out.printf("Total time: %d%n", b));

        playtime.entrySet()
                .stream()
                .sorted((b1, b2) -> {
                    if (b1.getValue() == b2.getValue()) {
                        return b1.getKey().compareTo(b2.getKey());
                    }
                    return b2.getValue() - b1.getValue();
                })
                .forEach((b) -> System.out.printf("%s -> %d%n", b.getKey(), b.getValue()));

        String bandMembers = sc.nextLine();
        System.out.println(bandMembers);
        for (String s : bands.get(bandMembers)) {
            System.out.printf("=> %s%n", s);
        }
    }

    private static void addMembers(String bandName ,String[] membersNames, Map<String, Set<String>> playList) {
        for (String membersName : membersNames) {
            playList.get(bandName).add(membersName);
        }
    }
}
