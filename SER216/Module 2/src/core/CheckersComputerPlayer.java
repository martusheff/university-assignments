/**
 * Logic for Checkers computer player.
 *
 * @author Andronick Martusheff
 * @version 1.1
 */

package core;

import java.util.Scanner;

/**
 * Main Player vs. CPU Method
 */
public class CheckersComputerPlayer {

    public static void playAgainstComputerUI() {
        System.out.println("Let's do this human!\n" +
                "I am the game. See that board? I made that. You're going down.\n");

        boolean gameOn = true;
        boolean turnP = true;
        boolean turnC = false;
        Scanner scan = new Scanner(System.in);
        CheckersLogic.Board board = new CheckersLogic.Board();
        board.displayBoard();
        System.out.println("Start game against computer.\nYou are player X. It is your turn.");
        System.out.println("Choose a cell position of piece to be moved and " +
                "the new position. ex. (3a-4b) or (3g-4h) ...");

        /**
         * While the game is in Progress
         */
        while (gameOn) {


            while (turnP) {

                System.out.println("Player X - your turn.");


                boolean pValid = true;

                while (pValid) {

                    String response = "";
                    response = scan.nextLine();

                    String[] parts = response.split("-");

                    /**
                     * @param string Passes in first part/potential move.
                     */
                    String getCoordinates = board.convertToUIFriendly(parts[0]);


                    int startX = getCoordinates.charAt(0) - '0';
                    int startY = getCoordinates.charAt(1) - '0';

                    /**
                     * @param string Passes in second part/potential move.
                     */
                    String setCoordinates = board.convertToUIFriendly(parts[1]);
                    int endX = setCoordinates.charAt(0) - '0';
                    int endY = setCoordinates.charAt(1) - '0';

                    try {
                        if (board.moveXPiece(startX, startY, endX, endY)) {
                            pValid = false;
                        } else {
                            System.out.println("Sorry, that was an invalid move.");
                        }
                    } catch (Error e) {
                        e.printStackTrace();
                        System.out.println("Player HUMAN was unable to move their XPiece.");
                    }
                    board.displayBoard();
                    turnP = false;
                    turnC = true;
                }

            }
            while (turnC) {


                String cpuPiece = board.getNextOPiece();
                CheckersLogic.OPiece o = board.returnOPiece(cpuPiece);


                String moves = board.getPossibleOMoves(o);
                int moveXpos = moves.charAt(0) - '0';
                int moveYpos = moves.charAt(1) - '0';

                try {
                    board.moveOXPiece(o.positionX, o.positionY, o);
                } catch (Error e) {
                    e.printStackTrace();
                    System.out.println("Computer was unable to make a move. You win.");
                }


                System.out.println("Computer moved.");


                board.displayBoard();
                turnC = false;
                turnP = true;

            }

            /**
             * Conditional for game over, winning decision.
             */
            if (board.isGameOver(board.OPieces)) {
                gameOn = false;
                System.out.println("Game is over. The human wins!!");
            }
            if (board.isGameOver(board.XPieces)) {
                gameOn = false;
                System.out.println("Game is over. The computer wins!!");
            }

        }
    }
}
