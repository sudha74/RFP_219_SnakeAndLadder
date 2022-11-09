package com.bl;

public class SnakeLadder {
    static final int START_POSITION = 0;

    public static void main(String[] args) {
        int dieNumber;
        int position = START_POSITION;
        System.out.println("current position : " + position);
        dieNumber = rollDie();

        System.out.println("Die Number : " + dieNumber);
    }

    static int rollDie() {
        int random = (int) (Math.random() * 10 % 6);
        return random;
    }
}
