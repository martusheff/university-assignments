// CSE 110     : Session A
// Assignment  : Assignment3.java
// Author      : Andronick Martusheff 1219284898
// Description : Determines stock trades from defined circumstances from user input.

import java.util.Scanner;

public class Assignment3 {

    public static void main(String[] args) {

        // declare and instantiate a Scanner
        Scanner scan = new Scanner(System.in);

        // declare and initialize variables
        int current_shares, purchase_price, market_price, available_funds, total_buy_cost, shares_to_sell,
                shares_to_buy, per_share_buy_value, total_buy_value, per_share_sell_value, total_sell_value;
        int FEE = 10;


        // prompt for and collect inputs
        System.out.printf("%-15s %s", "Current Share(s)", ": ");
        current_shares = scan.nextInt();
        System.out.printf("%-15s %s", "Purchase Price", ": ");
        purchase_price = scan.nextInt();
        System.out.printf("%-15s %s", "Market Price", ": ");
        market_price = scan.nextInt();
        System.out.printf("%-15s %s", "Available Funds", ": ");
        available_funds = scan.nextInt();

        // compute required values
        shares_to_buy = (available_funds - FEE) / market_price;
        total_buy_cost = FEE + (market_price * shares_to_buy);
        per_share_buy_value = purchase_price - market_price;
        per_share_sell_value = market_price - purchase_price;
        total_buy_value = per_share_buy_value * shares_to_buy;
        total_sell_value = per_share_sell_value * current_shares;

        // determining suggested action given user input
        if ((purchase_price - market_price) > 0) {
            shares_to_buy = (int) Math.floor((available_funds - FEE));
            total_buy_cost = 10 + (market_price * shares_to_buy);
            if (total_buy_cost == 10)
                System.out.print("Hold shares");
            else System.out.println("Buy " + shares_to_buy + " share(s)");
        } else if ((purchase_price - market_price) < 0) {
            total_sell_value = per_share_sell_value * current_shares;
            shares_to_sell = total_sell_value - FEE;
            if (shares_to_sell == 0)
                System.out.println("Hold share(s)");
            else
                System.out.println("Sell " + shares_to_sell + " share(s)");
        }
    }
}
