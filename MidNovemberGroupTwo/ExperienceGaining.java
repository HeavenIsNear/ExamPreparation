package com.company.Exams.MidNovemberGroupTwo;

import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double neededExperience = Double.parseDouble(sc.nextLine());
        int battles = Integer.parseInt(sc.nextLine());
        double totalExperience = 0;
        boolean isReady = false;
        int battlesPlayed = 0;

        for (int i = 1; i <= battles; i++) {
            double experiencePerBattle = Double.parseDouble(sc.nextLine());
            battlesPlayed++;
            double gainedExp = experiencePerBattle;
            if (i % 3 == 0) {
                gainedExp = experiencePerBattle * 1.15;
            }
            if (i % 5 == 0) {
                gainedExp = experiencePerBattle * 0.90;
            }
            totalExperience += gainedExp;
            if (totalExperience >= neededExperience) {
                isReady = true;
                break;
            }
        }
        if (isReady) {
            System.out.println(String.format("Player successfully collected his needed experience for %d battles.", battlesPlayed));
        } else {
            System.out.println(String.format("Player was not able to collect the needed experience, %.2f more needed.", neededExperience - totalExperience));
        }
    }
}
