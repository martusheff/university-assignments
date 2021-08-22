public class arrays2D {
    public static void main(String[] args) {
        int[][] lotteryCard = {
                {20, 15, 7},
                {8, 7, 19},
                {7, 13, 47}
        };



        for (int i = 0; i < lotteryCard.length; i++) {
            for (int j = 0; j < lotteryCard[i].length; j ++) {
                System.out.print(lotteryCard[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println(lotteryCard[1][2]);
    }
}
