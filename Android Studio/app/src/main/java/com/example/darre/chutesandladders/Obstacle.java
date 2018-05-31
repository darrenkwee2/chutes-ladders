package com.example.darre.chutesandladders;

public class Obstacle {
    private int startVal;
    private int endVal;

    public Obstacle(int startVal, int endVal)
    {
        this.startVal = startVal;
        this.endVal = endVal;
    }


    public int getEndVal()
    {
        return endVal;
    }
}
