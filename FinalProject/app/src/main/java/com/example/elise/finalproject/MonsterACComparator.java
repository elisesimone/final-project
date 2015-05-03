package com.example.elise.finalproject;

import java.util.Comparator;

/**
 * Created by Elise Johnson on 5/1/2015.
 */
public class MonsterACComparator implements Comparator<Monster> {
    public int compare(Monster m1, Monster m2) {
        return Integer.compare(m1.getAc(),m2.getAc());
    }
}
