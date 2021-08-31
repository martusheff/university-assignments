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
            super();
            this.isFilled = isFilled;
            this.positionY = positionY;
            this.positionX = positionX;
            this.move1 = new int[]{positionX, positionY + 1};
            this.move2 = new int[]{positionX, positionY - 1};

        }



        public void getPossibleMoves() {
            System.out.println(this.move1[0]+ "," + this.move1[1] + " | " + this.move2[0] + "," + this.move2[1]);
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

        public void getPossibleMoves() {
            System.out.println(this.move1[0]+ "," + this.move1[1] + " | " + this.move2[0] + "," + this.move2[1]);
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
            board[startX][startY] = new Piece();
            board[endX][endY] = o;
        }

        public void moveXPiece(int startX, int startY, int endX, int endY, XPiece x){
            board[startX][startY] = new Piece();
            board[endX][endY] = x;
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
                char y = coordinates.charAt(1);
                if(y == vert[i]) {
                    result += i;
                }
            }
            for(int i =0; i < 8; i ++) {
                char x = coordinates.charAt(0);
                if(x == horz[i]) {
                    result += i;
                }
            }


            System.out.println(result.charAt(0) + "," + result.charAt(1));
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
