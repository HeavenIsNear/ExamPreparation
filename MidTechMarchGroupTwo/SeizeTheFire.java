package com.company.Exams.MidTechMarchGroupTwo;

import java.util.ArrayList;
import java.util.Scanner;

public class SeizeTheFire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] cells = sc.nextLine().split("#");
        ArrayList<String> putOutCells = new ArrayList<>();
        int water = Integer.parseInt(sc.nextLine());
        double effort = 0;
        int totalFire = 0;

        for (String cell : cells) {
            String[] info = cell.split(" = ");
            String fireType = info[0];
            int intensity = Integer.parseInt(info[1]);

            if (checkRanges(fireType, intensity)) {
                if (water >= intensity) {
                    water -= intensity;
                    totalFire += intensity;
                    effort += intensity * 0.25;
                    putOutCells.add(" - " + intensity);
                }
            }
            if (water <= 0) {
                break;
            }
        }
        System.out.println("Cells:");
        for (String putOutCell : putOutCells) {
            System.out.println(putOutCell);
        }
        System.out.printf("Effort: %.2f%n", effort);
        System.out.printf("Total Fire: %d", totalFire);
    }

    private static boolean checkRanges(String fireType, int intensity) {
        switch (fireType) {
            case "High":
                return (intensity >= 81 && intensity <= 125);
            case "Medium":
                return (intensity >= 51 && intensity <= 80);
            case "Low":
                return (intensity >= 1 && intensity <= 50);
        }
        return false;
    }
}
