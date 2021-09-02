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

        boolean gameOn = true;
        boolean turnO = true;
        boolean turnX = false;
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


                    if(board.moveOPiece(startX, startY, endX, endY) == true) {
                        oValid = false;
                    } else {
                        System.out.println("Sorry, that was an invalid move.");
                    }


                }
                board.displayBoard();
                turnO = false;
                turnX = true;
            }

            while(turnX) {
                String response;
                System.out.println("Player X - your turn.");
                System.out.println();
                response = scan.nextLine();
                String[] parts = response.split("-");

                String getCoordinates = board.convertToUIFriendly(parts[0]);

                int startX = getCoordinates.charAt(0) - '0';


                int startY = getCoordinates.charAt(1) - '0';

                String setCoordinates = board.convertToUIFriendly(parts[1]);
                int endX = setCoordinates.charAt(0) - '0';
                int endY = setCoordinates.charAt(1) - '0';

                //XPiece x = board.getXPiece(startX,startY);



                board.moveXPiece(startX,startY, endX, endY);
                //x.getPossibleMoves();

                board.displayBoard();
                turnX = false;
                turnO = true;
            }
        }

    }
}


