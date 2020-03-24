package com.company.Exams.FinalAugust;

import java.util.*;

public class Followers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, List<Integer>> followers = new HashMap<>();

        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String username = tokens[1];

            if (command.equals("New follower")) {
                if (!followers.containsKey(username)) {
                    followers.put(username, new ArrayList<>());
                    followers.get(username).add(0, 0);
                    followers.get(username).add(1, 0);
                }
            } else if (command.equals("Like")) {
                int count = Integer.parseInt(tokens[2]);
                if (!followers.containsKey(username)) {
                    followers.put(username, new ArrayList<>());
                    followers.get(username).add(0, count);
                    followers.get(username).add(1, 0);
                } else {

                    followers.get(username).set(0, followers.get(username).get(0) + count);
                }
            } else if (command.equals("Comment")) {
                if (!followers.containsKey(username)) {
                    followers.put(username, new ArrayList<>());
                    followers.get(username).add(0, 0);
                    followers.get(username).add(1, 1);
                } else {
                    followers.get(username).set(1, followers.get(username).get(1) + 1);
                }
            } else if (command.equals("Blocked")) {
                if (followers.containsKey(username)) {
                    followers.remove(username);
                } else {
                    System.out.printf("%s doesn't exist.%n", username);
                }
            }

            input = sc.nextLine();
        }

        System.out.printf("%d followers%n", followers.size());
        followers.entrySet()
                .stream()
                .sorted((f1,f2) -> {
                    if (f1.getValue().get(0).equals(f2.getValue().get(0))) {
                        String first = f1.getKey();
                        String second = f2.getKey();
                        return first.compareTo(second);
                    } return f2.getValue().get(0) - f1.getValue().get(0);
                })
                .forEach(f -> System.out.printf("%s: %d%n", f.getKey(), f.getValue().get(0) + f.getValue().get(1)));
    }
}
