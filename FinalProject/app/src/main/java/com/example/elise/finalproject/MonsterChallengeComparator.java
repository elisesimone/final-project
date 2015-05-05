package com.example.elise.finalproject;

import java.util.Comparator;

/**
 * Created by Elise Johnson on 5/1/2015.
 */
public class MonsterChallengeComparator implements Comparator<Monster> {
    public int compare(Monster m1, Monster m2) {
        return ((Monster)m1).getChallenge().compareTo(((Monster)m2).getChallenge());
    }
}
