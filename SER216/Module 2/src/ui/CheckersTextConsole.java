package ui;
import core.*;
import java.util.Scanner;

public class CheckersTextConsole extends CheckersLogic {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        board.displayBoard();

        System.out.println("Begin Game. Player X - your turn.");
        System.out.println("Choose a cell position of piece to be moved and the new position. ex. (3a-4b) or (3g-4h) ...");
        String response = scan.nextLine();

        String[] parts = response.split("-");


        int startX = parts[0].charAt(0) - '0';

        System.out.println(startX);
        int startY = parts[0].charAt(1) - '0';

        int endX = parts[1].charAt(0) - '0';
        int endY = parts[1].charAt(1) - '0';


        OPiece o = (OPiece) board.getPiece(startY,startX);
        board.movePiece(startX,startY, endX, endY, o);

        board.displayBoard();
    }
}


