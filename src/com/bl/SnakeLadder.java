package com.bl;

public class SnakeLadder {
    static final int START_POSITION = 0;
    static final int LADDER_OPTION = 2;
    static final int SNAKE_OPTION = 1;
    static final int PLAYER_1 = 1;
    static final int PLAYER_2 = 2;

    public static void main(String[] args) {
        int dieNumber, option;
        int dieCount = 0;
        int player1Position = START_POSITION;
        int player2Position = START_POSITION;
        int currentPlayer = PLAYER_1;

        while (player1Position < 100 && player2Position < 100) {
            dieNumber = rollDie();
            dieCount++;
            System.out.println("Die Number : " + dieNumber);


            option = checkOption();

            switch (option) {
                case LADDER_OPTION:
                    System.out.println("ladder option");
                    if (currentPlayer == PLAYER_1) {
                        player1Position += dieNumber;
                    } else {
                        player2Position += dieNumber;
                    }
                    break;
                case SNAKE_OPTION:
                    System.out.println("snake option");
                    if (currentPlayer == PLAYER_1) {
                        player1Position -= dieNumber;
                    } else {
                        player2Position -= dieNumber;
                    }
                    currentPlayer = switchPlayer(currentPlayer);
                    break;
                default:
                    System.out.println("No play option");
                    currentPlayer = switchPlayer(currentPlayer);
                    break;
            }

            //ensure start position and exact winning position

            if (player1Position < 0) {
                player1Position = 0;
            } else if (player2Position < 0) {
                player2Position = 0;
            } else if (player1Position > 100) {
                player1Position -= dieNumber;
            } else if (player2Position > 100) {
                player2Position -= dieNumber;
            }
            System.out.println("current player1 position : " + player1Position);
            System.out.println("current player2 position : " + player2Position);
        }
        System.out.println("**************************************");
        showWinner(player1Position, player2Position);
        System.out.println("Number of times die played = " + dieCount);
    }

    static int rollDie() {
        int random = (int) (Math.random() * 10 % 6);
        return random;
    }

    static int checkOption() {
        int random = (int) (Math.random() * 10 % 3);
        return random;
    }

    static int switchPlayer(int currentPlayer) {
        if (currentPlayer == PLAYER_1) {
            return PLAYER_2;
        } else {
            return PLAYER_1;
        }
    }

    static void showWinner(int player1Position, int player2Position) {
        if (player1Position == 100) {
            System.out.println("Player1 is Winner");
        } else if (player2Position == 100) {
            System.out.println("Player2 is winner");
        }
    }
}
