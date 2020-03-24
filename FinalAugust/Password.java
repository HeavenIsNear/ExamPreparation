package com.company.Exams.FinalAugust;

import javax.xml.xpath.XPath;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("(.+)>(?<first>[\\d]{3})\\|(?<second>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[^<>]{3})<\\1");

        for (int i = 0; i < counter; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.printf("Password: %s%s%s%s%n", matcher.group("first"),
                                                            matcher.group("second"),
                                                            matcher.group("third"),
                                                            matcher.group("fourth"));
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
