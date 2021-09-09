/**
 * Logic for Checkers game (used by CheckersTextConsole.java).
 *
 * @author Andronick Martusheff
 * @version 1.0
 */


package core;




public class CheckersLogic {

    static class Piece {

        /**
         * @return creates an 'empty' piece.
         */
        public Piece() {
        }

        /**
         *
         * @return draws '_' to board to update UI with empty position.
         */
        public String toString() {
            return "_";
        }

    }

    public static class OPiece extends Piece {
        private final char name = 'o';
        private final int identifier;
        public int positionY, positionX;
        private int[] move1, move2;
        int[][] possibleMoves;


        /**
         * @param positionY vertical placement
         * @param positionX horizontal placement
         */

        public OPiece(int positionY, int positionX, int identifier) {
            this.identifier = identifier;
            this.positionY = positionY;
            this.positionX = positionX;
            this.move1 = new int[]{positionY + 1, positionX + 1};
            this.move2 = new int[]{positionY + 1, positionX - 1};

        }

        /**
         *
         * @return 'o' to string, displays 'o' on board.
         */
        public String toString() {
            return "o";
        }

    }

    public static class XPiece extends Piece {
        private final char name = 'x';
        private final int identifier;
        private int positionY, positionX;
        private int[] move1, move2;


        /**
         * @param positionY vertical placement
         * @param positionX horizontal placement
         */
        private XPiece(int positionY, int positionX, int identifier) {
            this.identifier = identifier;
            this.positionY = positionY;

            this.positionX = positionX;
            this.move1 = new int[]{positionY - 1, positionX-1};
            this.move2 = new int[]{positionY - 1, positionX+1};

        }

        /**
         *
         * @return 'x' to string, displays 'x' on board.
         */
        public String toString() {
            return "x";
        }

    }

    /**
     * Board constructor.
     */
    public static class Board {
        private Piece[][] board = new Piece[8][8];
        public int[] OPieces = new int[12];
        public int[] XPieces = new int[12];

        public Board() {
            getNewBoard();
        }

        /**
         * Move OPiece logic
         * @param startX starting horizontal position
         * @param startY starting vertical position
         * @param endX ending horizontal position
         * @param endY ending vertical position
         * @return boolean - successful move
         */
        public boolean moveOPiece(int startX, int startY, int endX, int endY){
            OPiece o = (OPiece) board[startX][startY];
            getPossibleOMoves(o);
            if(moveOPossible(o, endX, endY)) {
                System.out.println("Move possible!");
                board[startX][startY] = new Piece();
                board[endX][endY] = new OPiece(endX, endY, o.identifier);
                return true;
            } else {
                System.out.println("Move blocked.");
                return false;
            }


        }

        /**
         * Helper method for moving CPU piece.
         * @param startX start point X
         * @param startY start point Y
         * @param ox OPiece to be moved
         * @return boolean determining success of operation
         */
        public boolean moveOXPiece(int startX, int startY, OPiece ox) {
            XPiece o = (XPiece) board[startX][startY];
            getPossibleXMoves(o);
            getPossibleOMoves(ox);

            String moves = getPossibleOMoves(ox);
            int endX = moves.charAt(0) - '0';
            int endY = moves.charAt(1) - '0';
            String initialVals = getNextOPiece();
            startX = (int) initialVals.charAt(0) - '0';
            startY = (int) initialVals.charAt(1) - '0';

            if(moveOPossible(ox,endX,endY)) {
                System.out.println("Move possible!");
                board[startX][startY] = new Piece();
                board[endX][endY] = new OPiece(endX, endY, o.identifier);
                return true;
        }else {
                System.out.println("Move blocked.");
                return false;
            }


        }


        /**
         * Can the OPiece be moved to the requested end position.
         * @param o OPiece
         * @param endX horizontal end coordinate
         * @param endY vertical end coordinate
         * @return boolean: piece can be moved.
         */
        public boolean moveOPossible(OPiece o , int endX, int endY) {
            if(getPossibleOMoves(o).length() == 0) {
                return false;
            }
            if(o.move1 == null && o.move2 == null) {
                System.out.println("There are no possible moves for this piece.");
                return false;
            }
            if(o.move1 != null) {
                if (o.move1[0] == endX && o.move1[1] == endY) {
                    return true;
                }
            }
            if(o.move2 != null) {
                if (o.move2[0] == endX && o.move2[1] == endY) {
                    return true;
                }
            }
            return false;

        }

        /**
         * Determines whether or not moving X-Piece is possible.
         * @param x XPiece in question.
         * @param endX end x (vertical) location.
         * @param endY end y (horizontal) location.
         * @return boolean determining success of operation.
         */
        public boolean moveXPossible(XPiece x , int endX, int endY) {
            if(getPossibleXMoves(x).length() == 0) {
                return false;
            }
            if(x.move1 == null && x.move2 == null) {
                System.out.println("There are no possible moves for this piece.");
                return false;
            }
            if(x.move1 != null) {
                if (x.move1[0] == endX && x.move1[1] == endY) {
                    return true;
                }
            }
            if(x.move2 != null) {
                if (x.move2[0] == endX && x.move2[1] == endY) {
                    return true;
                }
            }
            return false;

        }

        /**
         * Move XPiece logic
         * @param startX starting horizontal position
         * @param startY starting vertical position
         * @param endX ending horizontal position
         * @param endY ending vertical position
         * @return boolean - successful move
         */
        public boolean moveXPiece(int startX, int startY, int endX, int endY){
            XPiece x = (XPiece) board[startX][startY];
            getPossibleXMoves(x);
            if(moveXPossible(x, endX, endY)) {
                board[startX][startY] = new Piece();
                board[endX][endY] = new XPiece(endX, endY, x.identifier);
                return true;
            } else {
                System.out.println("Move blocked.");
                return false;
            }
        }

        /**
         * Updates new board for new game start/initialization.
         */
        private void getNewBoard() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = new Piece();
                }
            }
            int oCounterID = 0;
            for(int i = 0; i < 3; i++) {
                for(int j = 1; j < board[i].length; j+=2) {
                    if(i % 2 == 0) {
                        board[i][j] = new OPiece(i, j, oCounterID);
                        if(oCounterID < 12) {
                            OPieces[oCounterID] = oCounterID;
                            oCounterID++;
                        }

                    }
                    if(i == 1) {
                        board[i][j - 1] = new OPiece(i, j, oCounterID++);
                        if(oCounterID < 12) {
                            OPieces[oCounterID] = oCounterID;
                            oCounterID++;
                        }
                    }
                }
            }

            int xCounterID = 0;
            for(int i = board.length - 1; i > 4; i --) {
                for(int j = 0; j < board[i].length; j+=2){
                    if(i % 2 == 1) {
                        board[i][j] = new XPiece(i, j,xCounterID);
                        if(xCounterID < 12) {
                            XPieces[xCounterID] = xCounterID;
                            xCounterID++;
                        }
                    }
                    if(i == 6) {
                        board[i][j + 1] = new XPiece(i, j,xCounterID);
                        if(xCounterID < 12) {
                            XPieces[xCounterID] = xCounterID;
                            xCounterID++;
                        }
                    }
                }
            }
        }

        /**
         * Game logic for deciding victor of game.
         * @param pieces once a piece is skipped over, its ID is set to -1. If no ID's have a value of > 0,
         *               or a piece type (o/x) no longer has any possible moves (see possibleMoves), the game over
         *               flag is thrown, indicating the game is now over.
         * @return over : boolean deciding whether the game is over or not
         */
        public boolean isGameOver(int[] pieces) {
            boolean over = true;
            for(int i = 0; i < pieces.length; i++) {
                if(pieces[i] != -1) {
                    over = false;
                }
            }
            return over;
        }
        /**
         * Returns potential moves for a given OPiece
         * @param o OPiece
         * @return possibleMoves - a string consisting of potential coordinates
         */
        public String getPossibleOMoves(OPiece o) {

            String possibleMoves = "";

            if(o.move1 != null) {
                if (o.move1[0] < 0 || o.move1[0] > 7 || o.move1[1] < 0 || o.move1[1] > 7) {
                    o.move1 = null;
                }
            }

            if(o.move2 != null) {
                if (o.move2[0] < 0 || o.move2[0] > 7 || o.move2[1] < 0 || o.move2[1] > 7) {
                    o.move2 = null;
                }
            }


            if (o.move1 != null) {
                if (!board[o.move1[0]][o.move1[1]].toString().equals("x")) {
                    possibleMoves += "" + o.move1[0] + "" + o.move1[1];
                }

            }

            if (o.move2 != null) {
                if (!board[o.move2[0]][o.move2[1]].toString().equals("x")) {
                    possibleMoves += "" + o.move2[0] + "" + o.move2[1];
                }




            }
            if(possibleMoves.length() > 0) {
            } else {
                System.out.println("No possible moves for this piece.");
            }
            return possibleMoves;
        }


        /**
         * Get next OPiece for Computer to play against.
         * @return nextPiece the string location of the next OPiece.
         */
        public String getNextOPiece() {
            String nextPiece = "";

            for (int i = board.length - 1; i >= 0; i--) {
                for (int j = board[i].length - 1; j >= 0; j--) {

                    if (board[i][j].toString().equals("o")) {
                        OPiece piece = (OPiece) board[i][j];
                        String potentialMoves = getPossibleOMoves(piece);

                        if (potentialMoves.length() > 0) {
                            nextPiece += i;
                            nextPiece += j;

                            return nextPiece;
                        }
                    }
                }


            }
            return nextPiece;
        }

        /**
         *
         * @param nextPiece returns CPU o Piece at a given index.
         * @return OPiece
         */
        public OPiece returnOPiece(String nextPiece) {

            return (OPiece) board[(int) nextPiece.charAt(0) - '0'][(int) nextPiece.charAt(1)- '0'];
        }

        /**
         * Returns potential moves for a given XPiece
         * @param x XPiece
         * @return possibleMoves - a string consisting of potential coordinates
         */
        public String getPossibleXMoves(XPiece x) {


            String possibleMoves = "";

            if(x.move1 != null) {
                if (x.move1[0] < 0 || x.move1[0] > 7 || x.move1[1] < 0 || x.move1[1] > 7) {
                    x.move1 = null;
                }
            }

            if(x.move2 != null) {
                if (x.move2[0] < 0 || x.move2[0] > 7 || x.move2[1] < 0 || x.move2[1] > 7) {
                    x.move2 = null;
                }
            }


            if (x.move1 != null) {
                if (!board[x.move1[0]][x.move1[1]].toString().equals("o")) {
                    possibleMoves += "" + x.move1[0] + "" + x.move1[1];
                }

            }

            if (x.move2 != null) {
                if (!board[x.move2[0]][x.move2[1]].toString().equals("o")) {
                    possibleMoves += "" + x.move2[0] + "" + x.move2[1];
                }




            }
            if(possibleMoves.length() > 0) {

            } else {
                System.out.println("No possible moves for this piece.");
            }
            return possibleMoves;
        }

        /**
         * Displays board to user in Console.
         * Call only after updating all game movements for a given turn.
         */
        public void displayBoard() {

            int vertPosCounter = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(j == 0){
                        System.out.print((Math.abs(vertPosCounter - board.length)) + " | ");
                        vertPosCounter++;
                    }
                    System.out.print(board[i][j] + " | ");

                }
                System.out.println();
            }
            System.out.println("    a   b   c   d   e   f   g   h");
        }


        /**
         * Converts the number, letter gave UI coordinate combo with numeric indexes
         * @param coordinates user entered coordinates
         * @return result respective numeric representation of UI
         */
        public String convertToUIFriendly(String coordinates) {
            String result = "";
            char[] vert = {'8','7','6','5','4','3','2','1'};
            char[] horz = {'a','b','c','d','e','f','g','h'};

            for(int i =0; i < 8; i ++) {
                char y = coordinates.charAt(0);
                if(y == vert[i]) {
                    result += i;
                }
            }
            for(int i =0; i < 8; i ++) {
                char x = coordinates.charAt(1);
                if(x == horz[i]) {
                    result += i;
                }
            }
            return result;

        }
    }

}
