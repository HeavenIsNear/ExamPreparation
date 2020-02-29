package com.company.MidExam;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int initialHealth = 100;
        int maxHealth = 100;
        int initialBitcoin = 0;
        int roomCounter = 0;
        boolean isDead = false;

        String[] rooms = sc.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            String[] tokens = rooms[i].split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            if ("potion".equals(command)) {
                roomCounter++;
                initialHealth  = healMe(number, initialHealth, maxHealth);
            } else if ("chest".equals(command)) {
                roomCounter++;
                initialBitcoin += number;
                System.out.printf("You found %d bitcoins.%n", number);
            } else {
                roomCounter++;
                initialHealth -= number;
                if (initialHealth > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d", roomCounter);
                    isDead = true;
                    break;
                }
            }
        }

        if (!isDead) {
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", initialBitcoin, initialHealth);
        }
    }

    private static int healMe(int health, int initialHealth, int maxHealth) {
        if (initialHealth + health >= maxHealth) {
            health = maxHealth - initialHealth;
            initialHealth = maxHealth;
        } else {
            initialHealth += health;
        }
        System.out.printf("You healed for %d hp.%n", health);
        System.out.printf("Current health: %d hp.%n", initialHealth);
        return initialHealth;
    }
}
