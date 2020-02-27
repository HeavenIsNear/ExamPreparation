package com.company.Exams.MidNovember;

import java.util.Scanner;

public class BiscuitsFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(sc.nextLine());
        int workers = Integer.parseInt(sc.nextLine());
        int competitorsBiscuits = Integer.parseInt(sc.nextLine());

        int totalBiscuits = 0;
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                totalBiscuits += workers * (biscuitsPerDay * 0.75);
            } else {
                totalBiscuits += workers * biscuitsPerDay;
            }
        }

        System.out.println(String.format("You have produced %d biscuits for the past month.", totalBiscuits));
        int difference = totalBiscuits - competitorsBiscuits;
        double percentage = (difference * 1.0 / competitorsBiscuits)  * 100;

        if(difference > 0) {
            System.out.println(String.format("You produce %.2f percent more biscuits.", percentage));
        } else {
            System.out.println(String.format("You produce %.2f percent less biscuits.", Math.abs(percentage)));
        }
    }
}
