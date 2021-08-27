interface piece {

}

public class CheckersLogic {
    Board testBoard = new Board();

    static class OPiece {
        private final char name = 'o';
        private int positionY, positionX;



        private OPiece(int positionY, int positionX) {
            this.positionY = positionY;
            this.positionX = positionX;
        }

        public void setPosition(int positionY, int positionX) {
            this.positionY = positionY;
            this.positionX = positionX;
        }

        public String toString() {
            return "" + this.name;
        }

    }

    public static class Board {
        private char[][] board = new char[8][8];



        private Board() {
            getNewBoard();
        }


        private void getNewBoard() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = '_';
                }
            }

            for(int i = 0; i < 3; i++) {
                for(int j = 1; j < board[i].length; j+=2) {
                    OPiece o = new OPiece(i,j);

                    if(i % 2 == 0)
                        board[i][j] = o.name;
                    if(i == 1)
                        board[i][j-1] = o.name;

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



    }


    public static void main(String[] args) {
        Board testBoard = new Board();
        testBoard.displayBoard();




    }





}
