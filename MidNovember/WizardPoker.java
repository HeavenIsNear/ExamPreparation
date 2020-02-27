package com.company.Exams.MidNovember;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] possibleCards = sc.nextLine().split(":");
        ArrayList<String> deck = new ArrayList<>();

        String input = sc.nextLine();
        while (!"Ready".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String cardName = tokens[1];

            if ("Add".equals(command)) {
                if (checkCardName(possibleCards, cardName)) {
                    deck.add(cardName);
                } else {
                    System.out.println("Card not found.");
                }
            } else if ("Insert".equals(command)) {
                int index = Integer.parseInt(tokens[2]);
                if (checkCardName(possibleCards, cardName) && (index >= 0 && index < deck.size())) {
                    deck.add(index, cardName);
                } else {
                    System.out.println("Error!");
                }
            } else if ("Remove".equals(command)) {
                if (checkCardName(possibleCards, cardName)) {
                    if (deck.contains(cardName)) {
                        deck.remove(cardName);
                    } else {
                        System.out.println("Card not found.");
                    }
                } else {
                    System.out.println("Card not found.");
                }
            } else if ("Swap".equals(command)) {
                String swapCard = tokens[2];
                swapCards(deck, cardName, swapCard);
            } else if ("Shuffle".equals(command)) {
                shuffleDeck(deck);
            }

            input = sc.nextLine();
        }
        for (String s : deck) {
            System.out.print(s + " ");
        }
    }

    private static void shuffleDeck(ArrayList<String> deck) {
        Collections.reverse(deck);
    }

    private static void swapCards(ArrayList<String> deck, String firstCard, String secondCard) {
        int indexFirst = deck.indexOf(firstCard);
        int indexSecond = deck.indexOf(secondCard);
        String temp = deck.get(indexFirst);
        deck.set(indexFirst, secondCard);
        deck.set(indexSecond, temp);
    }

    private static boolean checkCardName(String[] possibleCards, String cardName) {
        for (String possibleCard : possibleCards) {
            if (possibleCard.equals(cardName)) {
                return true;
            }
        }
        return false;
    }
}
