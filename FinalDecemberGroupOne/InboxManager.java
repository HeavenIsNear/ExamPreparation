package com.company.Exams.FinalDecemberGroupOne;

import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> emails = new HashMap<>();

        String input = sc.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];

            if (command.equals("Add")) {
                if (emails.containsKey(username)) {
                    System.out.printf("%s is already registered%n", username);
                } else {
                    emails.put(username, new ArrayList<>());
                }
            } else if (command.equals("Send")) {
                String email = tokens[2];
                if (emails.containsKey(username)) {
                    emails.get(username).add(email);
                }
            } else if (command.equals("Delete")) {
                if (!emails.containsKey(username)) {
                    System.out.printf("%s not found!%n", username);
                } else {
                    emails.remove(username);
                }
            }

            input = sc.nextLine();
        }
        System.out.printf("Users count: %d%n", emails.size());
        emails.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().size() == e2.getValue().size()) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return e2.getValue().size() - e1.getValue().size();
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(s -> System.out.printf(" - %s%n", s));
                });
    }
}
