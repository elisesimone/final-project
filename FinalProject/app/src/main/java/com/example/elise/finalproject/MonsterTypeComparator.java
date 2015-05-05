package com.example.elise.finalproject;

import java.util.Comparator;

/**
 * Created by Elise Johnson on 5/4/2015.
 */
public class MonsterTypeComparator implements Comparator<Monster> {
    public int compare(Monster m1, Monster m2) {
        return ((Monster)m1).getType().compareTo(((Monster)m2).getType());
    }
}
