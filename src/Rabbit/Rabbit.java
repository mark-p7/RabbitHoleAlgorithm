package Rabbit;

import java.util.Random;

public class Rabbit {

    private int currentLocation;
    private final int upperBound = 99;
    private final int lowerBound = 0;

    public Rabbit() {
        currentLocation = new Random().nextInt(100);
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    void move() {

        int move = new Random().nextInt(2);
        if (isInvalidUpperBound(move, currentLocation)) {
            move = 0;
        }
        if (isInvalidLowerBound(move, currentLocation)) {
            move = 1;
        }

        if (move == 0) {
            currentLocation--;
        } else {
            currentLocation++;
        }
    }

    boolean isInvalidUpperBound(int move, int currentLocation) {
        return currentLocation + move > upperBound;
    }

    boolean isInvalidLowerBound(int move, int currentLocation) {
        return currentLocation - move < lowerBound;
    }

    int getCurrentLocation() {
        return currentLocation;
    }
}
