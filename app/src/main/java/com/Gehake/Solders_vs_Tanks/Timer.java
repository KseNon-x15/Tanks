package com.Gehake.Solders_vs_Tanks;

public class Timer {

    private static long second = 1000000000;
    private long lastTime;


    private long getDeltaTime(){
        return (System.nanoTime()-lastTime);
    }


    private void updateTime(){
        this.lastTime = System.nanoTime();
    }


    public Timer() {
        this.lastTime = System.nanoTime();
    }

    public boolean hasSecondPassed() {
        if (getDeltaTime() >= second) {
            updateTime();
            return true;
        }
        else return false;
    }
}