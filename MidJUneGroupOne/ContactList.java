package com.company.Exams.MidJUneGroupOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ContactList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split("\\s+");
        ArrayList<String> contacts = new ArrayList<>(Arrays.asList(array));

        String input = sc.nextLine();
        while (!input.contains("Print")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if ("Add".equals(command)) {
                String contactName = tokens[1];
                int index = Integer.parseInt(tokens[2]);
                if (indexValidator(contacts, index)) {
                    if (contacts.contains(contactName)) {
                        contacts.add(index, contactName);
                    } else {
                        contacts.add(contactName);
                    }
                }
            } else if ("Remove".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                if (indexValidator(contacts, index)) {
                    contacts.remove(index);
                }
            } else if ("Export".equals(command)) {
                int startIndex = Integer.parseInt(tokens[1]);
                int count = Integer.parseInt(tokens[2]);
                for (int i = 0; i < count; i++) {
                    System.out.print(contacts.get(startIndex) + " ");
                    startIndex++;
                    if (startIndex == contacts.size()) {
                        break;
                    }
                }
                System.out.println();
            }

            input = sc.nextLine();
        }
        String[] ending = input.split("\\s+");
        if (!"Normal".equals(ending[1])) {
            Collections.reverse(contacts);
        }
        System.out.print("Contacts: ");
        System.out.println(String.join(" ", contacts));
    }

    private static boolean indexValidator(ArrayList<String> contacts, int index) {
        return (index >= 0 && index < contacts.size());
    }
}
