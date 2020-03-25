package com.company.Exams.FinalAugustGroupOne;

import java.sql.PseudoColumnUsage;
import java.util.*;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> stats = new HashMap<>();

        int capacity = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("=");
            String command = tokens[0];

            if (command.equals("Add")) {
                String username = tokens[1];
                int sentCount = Integer.parseInt(tokens[2]);
                int receivedCount = Integer.parseInt(tokens[3]);

                if (!stats.containsKey(username)) {
                    stats.put(username, new ArrayList<>());
                    stats.get(username).add(0, sentCount);
                    stats.get(username).add(1, receivedCount);
                }
            } else if (command.equals("Message")) {
                String sender = tokens[1];
                String receiver = tokens[2];

                if (stats.containsKey(sender) && stats.containsKey(receiver)) {
                    stats.get(sender).set(0, stats.get(sender).get(0) + 1);
                    stats.get(receiver).set(1, stats.get(receiver).get(1) + 1);

                    if (stats.get(sender).get(0) + stats.get(sender).get(1) >= capacity) {
                        stats.remove(sender);
                        System.out.printf("%s reached the capacity!%n", sender);
                    }
                    if (stats.get(receiver).get(0) + stats.get(receiver).get(1) >= capacity) {
                        stats.remove(receiver);
                        System.out.printf("%s reached the capacity!%n", receiver);
                    }
                }
            } else if (command.equals("Empty")) {
                String name = tokens[1];

                if (name.equals("All")) {
                    stats.clear();
                } else {
                    stats.remove(name);
                }
            }

            input = sc.nextLine();
        }

        System.out.printf("Users count: %d%n", stats.size());
        stats.entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    if (u1.getValue().get(1) == u2.getValue().get(1)) {
                        return u1.getKey().compareTo(u2.getKey());
                    }
                    return u2.getValue().get(1) - u1.getValue().get(1);
                })
                .forEach(u -> System.out.printf("%s - %d%n", u.getKey(), u.getValue().get(0) + u.getValue().get(1)));
    }
}
