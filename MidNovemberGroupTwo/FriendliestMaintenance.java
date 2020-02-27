package com.company.Exams.MidNovemberGroupTwo;

import java.util.Scanner;

public class FriendliestMaintenance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] friendsList = sc.nextLine().split(", ");
        String input = sc.nextLine();
        int blackListed = 0;
        int lost = 0;

        while (!"Report".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if ("Blacklist".equals(command)) {
                String name = tokens[1];
                if (checkIfExisting(friendsList, name)) {
                    blackListed++;
                    int index = findIndexOfName(friendsList, name);
                    System.out.println(String.format("%s was blacklisted.", name));
                    friendsList[index] = "Blacklisted";
                } else {
                    System.out.println(String.format("%s was not found.", name));
                }
            } else if ("Error".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                String currentName = friendsList[index];
                if (!currentName.equals("Blacklisted") && !currentName.equals("Lost")) {
                    lost++;
                    System.out.println(String.format("%s was lost due to an error.", currentName));
                    friendsList[index] = "Lost";
                }
            } else if ("Change".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                String newName = tokens[2];
                if (index >= 0 && index < friendsList.length) {
                    String temp = friendsList[index];
                    System.out.println(String.format("%s changed his username to %s.", temp, newName));
                    friendsList[index] = newName;
                }
            }

            input = sc.nextLine();
        }
        System.out.println(String.format("Blacklisted names: %d", blackListed));
        System.out.println(String.format("Lost names: %d", lost));
        String result = String.join(" ", friendsList);
        System.out.println(result);
    }

    private static int findIndexOfName(String[] friendsList, String name) {
        int index = 0;
        for (int i = 0; i < friendsList.length; i++) {
            if (friendsList[i].equals(name)) {
                index = i;
            }
        }
        return index;
    }

    private static boolean checkIfExisting(String[] friendsList, String name) {
        for (String s : friendsList) {
            if (s.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
