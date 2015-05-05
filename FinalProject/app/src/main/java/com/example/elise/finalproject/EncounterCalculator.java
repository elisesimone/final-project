package com.example.elise.finalproject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Alex on 5/4/2015.
 */
public class EncounterCalculator {

    private int[] monsterXp = new int[]{10,25,50,100,200,450,700,1100,1800,2300,2900,3900,
                                        5000,5900,7200,8400,10000,11500,13000,15000,18000,
                                        20000,22000,25000,27500,30000,32500,36500};
    private int[] xpThreshold1 = new int[]{25,50,75,100};
    private int[] xpThreshold2 = new int[]{50,100,150,200};
    private int[] xpThreshold3 = new int[]{75,150,225,400};
    private int[] xpThreshold4 = new int[]{125,250,375,500};
    private int[] xpThreshold5 = new int[]{250,500,750,1100};
    private int[] xpThreshold6 = new int[]{300,600,900,1400};
    private int[] xpThreshold7 = new int[]{350,750,1100,1700};
    private int[] xpThreshold8 = new int[]{450,900,1400,2100};
    private int[] xpThreshold9 = new int[]{550,1100,1600,2400};
    private int[] xpThreshold10 = new int[]{600,1200,1900,2800};
    private int[] xpThreshold11 = new int[]{800,1600,2400,3600};
    private int[] xpThreshold12 = new int[]{1000,2000,3000,4500};
    private int[] xpThreshold13 = new int[]{1100,2200,3400,5100};
    private int[] xpThreshold14 = new int[]{1250,2500,3800,5700};
    private int[] xpThreshold15 = new int[]{1400,2800,4300,6400};
    private int[] xpThreshold16 = new int[]{1600,3200,4800,7200};
    private int[] xpThreshold17 = new int[]{2000,3900,5900,8800};
    private int[] xpThreshold18 = new int[]{2100,4200,6300,9500};
    private int[] xpThreshold19 = new int[]{2400,4900,7300,10900};
    private int[] xpThreshold20 = new int[]{2800,5700,8500,12700};
    private int[][] xpThresholds = new int[][]{xpThreshold1,xpThreshold2,xpThreshold3,xpThreshold4,
                                               xpThreshold15,xpThreshold16,xpThreshold17,xpThreshold18,
                                               xpThreshold9,xpThreshold10,xpThreshold11,xpThreshold12,
                                               xpThreshold13,xpThreshold14,xpThreshold15,xpThreshold16,
                                               xpThreshold17,xpThreshold18,xpThreshold19,xpThreshold20};

    public EncounterCalculator(){

    }

    /*
    calcPartyThreshold
    Calculates the parties total XP for the Easy, Medium, Hard, and Deadly
    encounter thresholds.
     */
    private int[] calcPartyThreshold(int partySize, int partyLvl){
        int[] tmpXpThreshold = new int[4];
        for(int i=0; i<4; i++){
            tmpXpThreshold[i] = xpThresholds[partyLvl][i]*partySize;
        }
        return tmpXpThreshold;
    }

    /*
    calcMonsterXp
    Calculates the total XP of all monsters in the encounter.
    This result is used for comparison with the party xp threshold.
     */
    private int calcMonsterXp(int numMonsters, int CR){
        double multiplier = 1; //Depending on the number of monsters, a multiplier is applied to the total
        if(numMonsters>1){
            if(numMonsters == 2)
                multiplier = 1.5;
            else if(numMonsters<=6)
                multiplier = 2;
            else if(numMonsters<=10)
                multiplier = 2.5;
            else if(numMonsters<=14)
                multiplier = 3;
            else
                multiplier = 4;
        }

        return (int)((numMonsters*monsterXp[CR])*multiplier);

    }
    /*
    calculateEncounter
    Compares the parties XP thresholds to the total XP of the monsters then assigns the
    appropriate difficulty level to the encounter.
     */
    public String calculateEncounter(int partySize, int partyLvl, int numMonsters, int CR){
        int[] tempXpThreshold;
        int monsterXP;
        String result = "N/A";
        tempXpThreshold = calcPartyThreshold(partySize,partyLvl);
        monsterXP = calcMonsterXp(numMonsters,CR);
        if(monsterXP<tempXpThreshold[0])
            result = "Trivial";
        else if(monsterXP>=tempXpThreshold[0] && monsterXP<tempXpThreshold[1])
            result = "Easy";
        else if(monsterXP==tempXpThreshold[1] && monsterXP<tempXpThreshold[2])
            result = "Medium";
        else if(monsterXP==tempXpThreshold[2] && monsterXP<tempXpThreshold[3])
            result = "Hard";
        else
            result = "Deadly";

        return result;
    }


}
