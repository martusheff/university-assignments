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


    static class OPiece extends Piece {
        private final char name = 'o';
        private int positionY, positionX;



        private OPiece(int positionY, int positionX, boolean isFilled) {
            super();
            this.isFilled = isFilled;
            this.positionY = positionY;
            this.positionX = positionX;
        }

        public void setPosition(int positionY, int positionX) {
            this.positionY = positionY;
            this.positionX = positionX;
        }

        public String toString() {
            return "o";
        }

    }

    static class XPiece extends Piece {
        private final char name = 'o';
        private int positionY, positionX;



        private XPiece(int positionY, int positionX, boolean isFilled) {
            super();
            this.isFilled = isFilled;
            this.positionY = positionY;
            this.positionX = positionX;
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

        private Board() {
            getNewBoard();
        }

        private void movePiece(int startX, int startY, int endX, int endY, OPiece o){
            board[startY][startX] = new Piece();
            board[endY][endX] = o;
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

        private void displayBoard() {

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

        private Piece getPiece(int y, int x) {
            return board[y][x];
        }


    }


    public static void main(String[] args) {
        Board board = new Board();
        board.displayBoard();

        OPiece o = (OPiece) board.getPiece(2,1);

        board.movePiece(1,2,2,3, o);

        board.displayBoard();





    }





}
