import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Alex on 5/4/2015.
 */
public class EncounterCalculator {
    private int partySize;
    private int partyLvl;
    private int numMonsters;
    private int CR;
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

    private int[] calcPartyThreshold(int partySize, int partyLvl){
        int[] tmpXpThreshold = new int[4];
        for(int i=0; i<4; i++){
            tmpXpThreshold[i] = xpThresholds[partyLvl][i]*partySize;
        }
        return tmpXpThreshold;
    }


}
