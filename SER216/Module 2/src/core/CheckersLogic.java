package core;

interface piece {

}

public class CheckersLogic {


    Board testBoard = new Board();



    static class Piece {
        boolean isFilled = false;


        public Piece(boolean isFilled) {
            this.isFilled = isFilled;
        }

        public Piece() {

        }

        public String toString() {
            return "_";
        }

    }


    public static class OPiece extends Piece {
        private final char name = 'o';
        private int positionY, positionX;
        private int[] move1, move2;
        int[][] possibleMoves;



        private OPiece(int positionY, int positionX, boolean isFilled) {
            this.isFilled = isFilled;
            this.positionY = positionY;
            this.positionX = positionX;
            this.move1 = new int[]{positionY + 1, positionX + 1};
            this.move2 = new int[]{positionY + 1, positionX - 1};

        }



        public String getPossibleMoves(OPiece o) {

            String possibleMoves = "";

            if(o.move1[0] < 0 || o.move1[0] > 7)
                o.move1 = null;

            if(o.move1[1] < 0 || o.move1[1] > 7)
                o.move1 = null;

            if(o.move2[0] < 0 || o.move2[0] > 7)
                o.move2 = null;

            if(o.move2[1] < 0 || o.move2[1] > 7)
                o.move2 = null;

            if(o.move1 != null) {
                possibleMoves += "" + o.move1[0] + "" + o.move1[1];
            }

            if(o.move2 != null) {
                possibleMoves += "" + o.move2[0] + "" + o.move2[1];
            }
            System.out.println(possibleMoves);

            return possibleMoves;
        }

        public void setPosition(int positionY, int positionX) {
            this.positionY = positionY;
            this.positionX = positionX;
        }

        public String toString() {
            return "o";
        }

    }

    public static class XPiece extends Piece {
        private final char name = 'x';
        private int positionY, positionX;
        private int[] move1, move2;



        private XPiece(int positionY, int positionX, boolean isFilled) {
            this.isFilled = isFilled;
            this.positionY = positionY;
            this.positionX = positionX;
            this.move1 = new int[]{positionY - 1, positionX-1};
            this.move2 = new int[]{positionY - 1, positionX+1};

        }


        public void setPosition(int positionY, int positionX) {
            this.positionY = positionY;
            this.positionX = positionX;
        }

        public String toString() {
            return "x";
        }

    }

    public static class Board {
        private Piece[][] board = new Piece[8][8];

        public Board() {
            getNewBoard();
        }

        public void moveOPiece(int startX, int startY, int endX, int endY){
            OPiece o = (OPiece) board[startX][startY];
            getPossibleOMoves(o);
            if(movePossible(o, endX, endY) == true) {
                System.out.println("Move possible!");
            } else {
                System.out.println("Move blocked.");
            }
            board[startX][startY] = new Piece();
            board[endX][endY] = new OPiece(endX, endY, true);

        }

        public boolean movePossible(OPiece o , int endX, int endY) {
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

        public void moveXPiece(int startX, int startY, int endX, int endY){
            XPiece x = (XPiece) board[startX][startY];
            getPossibleXMoves(x);
            board[startX][startY] = new Piece();
            board[endX][endY] = new XPiece(endX, endY, true);
        }

        private void getNewBoard() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = new Piece();
                }
            }
            for(int i = 0; i < 3; i++) {
                for(int j = 1; j < board[i].length; j+=2) {
                    if(i % 2 == 0)
                        board[i][j] = new OPiece(i,j,true);
                    if(i == 1)
                        board[i][j-1] = new OPiece(i,j,true);
                }
            }
            for(int i = board.length - 1; i > 4; i --) {
                for(int j = 0; j < board[i].length; j+=2){
                    if(i % 2 == 1)
                        board[i][j] = new XPiece(i,j,true);
                    if(i == 6)
                        board[i][j+1] = new XPiece(i,j,true);
                }
            }
        }

        public String getPossibleOMoves(OPiece o) {

            String possibleMoves = "";


            if (o.move1[0] < 0 || o.move1[0] > 7 || o.move1[1] < 0 || o.move1[1] > 7) {
                o.move1 = null;
            }

            if (o.move2[0] < 0 || o.move2[0] > 7 || o.move2[1] < 0 || o.move2[1] > 7) {
                o.move2 = null;
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
                System.out.println(possibleMoves);
            } else {
                System.out.println("No possible moves for this piece.");
            }
            return possibleMoves;
        }


        public String getPossibleXMoves(XPiece x) {


            String possibleMoves = "";


            if (x.move1[0] < 0 || x.move1[0] > 7 || x.move1[1] < 0 || x.move1[1] > 7) {
                x.move1 = null;
            }

            if (x.move2[0] < 0 || x.move2[0] > 7 || x.move2[1] < 0 || x.move2[1] > 7) {
                x.move2 = null;
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
                System.out.println(possibleMoves);
            } else {
                System.out.println("No possible moves for this piece.");
            }
            return possibleMoves;
        }
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


            //System.out.println(result.charAt(0) + "," + result.charAt(1));
            return result;

        }

        public OPiece getOPiece(int y, int x) {
            OPiece o = (OPiece) board[y][x];
            return o;
        }

        public XPiece getXPiece(int y, int x) {
            XPiece xP = (XPiece) board[y][x];
            return xP;
        }





    }






}
