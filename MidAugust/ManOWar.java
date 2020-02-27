package com.company.Exams.MidAugust;

import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isSunken = false;

        String[] firstShip = sc.nextLine().split(">");
        int[] pirateShip = new int[firstShip.length];
        for (int i = 0; i < firstShip.length; i++) {
            pirateShip[i] = Integer.parseInt(firstShip[i]);
        }

        String[] secondShip = sc.nextLine().split(">");
        int[] warShip = new int[secondShip.length];
        for (int i = 0; i < secondShip.length; i++) {
            warShip[i] = Integer.parseInt(secondShip[i]);
        }
        int maximumHealth = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();

        while(!"Retire".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if ("Fire".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                int damage = Integer.parseInt(tokens[2]);
                if (indexValidator(warShip, index)) {
                    boolean isDamaged = damageWarship(warShip, index, damage);
                    if (isDamaged) {
                        System.out.println("You won! The enemy ship has sunken.");
                        isSunken = true;
                        break;
                    }
                }
            } else if ("Defend".equals(command)) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                int damage = Integer.parseInt(tokens[3]);
                if (indexValidator(pirateShip, startIndex, endIndex)) {
                    boolean isDamaged = damagePirateShip(pirateShip, startIndex, endIndex, damage);
                    if (isDamaged) {
                        System.out.println("You lost! The pirate ship has sunken.");
                        isSunken = true;
                        break;
                    }
                }
            } else if ("Repair".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                int healing = Integer.parseInt(tokens[2]);
                if (indexValidator(pirateShip, index)) {
                    repairPirateShip(pirateShip, index, healing, maximumHealth);
                }
            } else if ("Status".equals(command)) {
                int sections = countDamagedSections(pirateShip, maximumHealth);
                System.out.println(String.format("%d sections need repair.", sections));
            }

            input = sc.nextLine();
        }
        int pirateStatus = findFinalStatus(pirateShip);
        int warStatus = findFinalStatus(warShip);
        if (!isSunken) {
            System.out.printf("Pirate ship status: %d%n", pirateStatus);
            System.out.printf("Warship status: %d", warStatus);
        }
    }

    private static int findFinalStatus(int[] ship) {
        int sum = 0;
        for (int i : ship) {
            sum += i;
        }
        return sum;
    }

    private static int countDamagedSections(int[] ship, int maximumHealth) {
        int counter = 0;
        for (int i : ship) {
            double percents = (i * 1.0 / maximumHealth * 1.0) * 100;
            if (percents < 20) {
                counter++;
            }
        }
        return counter;
    }

    private static void repairPirateShip(int[] ship, int index, int healing, int maximumHealth) {
        ship[index] = ship[index] + healing;
        if (ship[index] > maximumHealth) {
            ship[index] = maximumHealth;
        }
    }

    private static boolean damagePirateShip(int[] ship, int startIndex, int endIndex, int damage) {
        for (int i = startIndex; i <= endIndex; i++) {
            ship[i] = ship[i] - damage;
            if (ship[i] <= 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean damageWarship(int[] ship, int index, int damage) {
        ship[index] = ship[index] - damage;
        return  (ship[index] <= 0);
    }

    private static boolean indexValidator(int[] ship, int index) {
        return (index >= 0 && index < ship.length);
    }


    private static boolean indexValidator(int[] ship, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            if (startIndex >= 0 && startIndex < ship.length - 1) {
                return endIndex < ship.length;
            }
        }
        return false;
    }
}
