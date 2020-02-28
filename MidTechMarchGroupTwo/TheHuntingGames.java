package com.company.Exams.MidTechMarchGroupTwo;

import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int players = Integer.parseInt(sc.nextLine());
        double energy = Double.parseDouble(sc.nextLine());
        double waterPerDayPerPlayer = Double.parseDouble(sc.nextLine());
        double foodPerDayPerPlayer = Double.parseDouble(sc.nextLine());
        double neededWater = waterPerDayPerPlayer * players * days;
        double neededFood = foodPerDayPerPlayer * players * days;
        boolean isEnergyGone = false;

        for (int i = 1; i <= days; i++) {
            double lossOfEnergy = Double.parseDouble(sc.nextLine());
            energy -= lossOfEnergy;
            if (energy <= 0) {
                isEnergyGone = true;
                break;
            }
            if (i % 2 == 0) {
                neededWater -= neededWater * 0.30;
                energy += energy * 0.05;
            }
            if (i % 3 == 0) {
                neededFood -= neededFood / players;
                energy += energy * 0.10;
            }
        }
        if (isEnergyGone) {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", neededFood, neededWater);
        } else {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energy);
        }
    }
}
