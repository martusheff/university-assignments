/**
 * Checkers console UI.
 *
 * @author Andronick Martusheff
 * @version 1.0
 */


package ui;
import core.*;
import java.util.Scanner;

/**
 * Main game loop.
 */
public class CheckersTextConsole extends CheckersLogic {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Begin Game. Enter ‘P’ " +
                "if you want to play against another player; " +
                "enter ‘C’ to play against computer.\n");
        String gameMode = scan.next();
        if(gameMode.equals("P")) {
            playAgainstPlayerUI();
        } else if(gameMode.equals("C")) {
            CheckersComputerPlayer.playAgainstComputerUI();
        }

    }


    /**
     * Holds main player vs player UI interaction.
     */
    public static void playAgainstPlayerUI() {

        System.out.println("Oh? You actually have friends to play with? Alright I guess...\n" +
                "Here's your new game board. Have fun!\n");

        boolean gameOn = true;
        boolean turnO = false;
        boolean turnX = true;
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        board.displayBoard();
        System.out.println("Begin Game.");
        System.out.println("Choose a cell position of piece to be moved and " +
                "the new position. ex. (3a-4b) or (3g-4h) ...");

        /**
         * Conditional for game continuation.
         */
        while (gameOn) {


            while(turnO) {

                System.out.println("Player O - your turn.");


                boolean oValid = true;

                while(oValid) {

                    String response = "";
                    response = scan.nextLine();

                    String[] parts = response.split("-");

                    String getCoordinates = board.convertToUIFriendly(parts[0]);


                    int startX = getCoordinates.charAt(0) - '0';
                    int startY = getCoordinates.charAt(1) - '0';

                    String setCoordinates = board.convertToUIFriendly(parts[1]);
                    int endX = setCoordinates.charAt(0) - '0';
                    int endY = setCoordinates.charAt(1) - '0';
                    //OPiece o = board.getOPiece(startY,startX);
                    try {
                        if (board.moveOPiece(startX, startY, endX, endY)) {
                            oValid = false;
                        } else {
                            System.out.println("Sorry, that was an invalid move.");
                        }
                    } catch (Error e) {
                        e.printStackTrace();
                        System.out.println("Unable to move OPiece error.");
                    }


                }
                board.displayBoard();
                turnO = false;
                turnX = true;
            }

            while(turnX) {

                System.out.println("Player X - your turn.");
                boolean xValid = true;
                while(xValid) {


                    String response;
                    System.out.println();
                    response = scan.nextLine();
                    String[] parts = response.split("-");

                    String getCoordinates = board.convertToUIFriendly(parts[0]);

                    int startX = getCoordinates.charAt(0) - '0';


                    int startY = getCoordinates.charAt(1) - '0';

                    String setCoordinates = board.convertToUIFriendly(parts[1]);
                    int endX = setCoordinates.charAt(0) - '0';
                    int endY = setCoordinates.charAt(1) - '0';



                    try {
                        if (board.moveXPiece(startX, startY, endX, endY)) {
                            xValid = false;
                        } else {
                            System.out.println("Sorry, that was an invalid move.");
                        }
                    } catch (Error e) {
                        e.printStackTrace();
                        System.out.println("Unable to move XPiece error. Reference error.");
                    }

                }
                board.displayBoard();
                turnX = false;
                turnO = true;
            }


            if(board.isGameOver(board.OPieces)) {
                gameOn = false;
                System.out.println("Game is over. X wins!");
            }
            if(board.isGameOver(board.XPieces)) {
                gameOn = false;
                System.out.println("Game is over. O wins!");
            }
        }
    }

}


