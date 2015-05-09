package com.example.elise.finalproject;

import java.util.Comparator;

/**
 * Created by Elise Johnson on 5/1/2015.
 */
public class MonsterChallengeComparator implements Comparator<Monster> {
    public int compare(Monster m1, Monster m2) {
        String challenge1 = m1.getChallenge();
        String challenge2 = m2.getChallenge();
        String[] fraction1;
        String[] fraction2;
        if (challenge1.contains("/")){
            fraction1 = challenge1.split("/");
        } else {
            fraction1 = new String[]{challenge1,"1"};
        }

        if (challenge2.contains("/")){
            fraction2 = challenge2.split("/");
        } else {
            fraction2 = new String[]{challenge2,"1"};
        }
        Double numer1 = Double.valueOf(fraction1[0]);
        Double numer2 = Double.valueOf(fraction2[0]);
        Double denom1 = Double.valueOf(fraction1[1]);
        Double denom2 = Double.valueOf(fraction2[1]);
        Double value1 = numer1/denom1;
        Double value2 = numer2/denom2;

        return value1.compareTo(value2);
    }
}
