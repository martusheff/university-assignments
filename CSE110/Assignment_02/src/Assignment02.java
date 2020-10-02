// CSE 110     : Online A
// Assignment  : Assignment02.java
// Author      : Andronick Martusheff - 1219284898
// Description : Determining costs and material requirements for road construction projects.

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Assignment02 {
    public static void main(String[] args) {

        // declaring scanner for input
        Scanner input = new Scanner(System.in);

        // permanent variables being called and set beforehand
        int MAX_LOAD = 10000; // LBS
        int ROAD_WIDTH = 12; //FT
        int ASPHALT_WEIGHT = 150; //LBS
        int CONDUIT_LENGTH = 24; //FT
        int CONDUIT_COST = 500; //USD
        int STOPLIGHT_COST = 25000; //USD
        int WORK_DAY = 8; //HOURS
        int WORK_RATE = 25; //USD
        int MILE = 5280; //FT


        // declaring input variables
        double length_of_road;
        int number_of_lanes, asphalt_depth, days_to_complete;


        // taking user input
        System.out.printf("%-30s %s", "Length of road project (miles)", ": ");
        length_of_road = input.nextDouble();
        System.out.printf("%-30s %s", "Number of lanes", ": ");
        number_of_lanes = input.nextInt();
        System.out.printf("%-30s %s", "Depth of asphalt (inches)", ": ");
        asphalt_depth = input.nextInt();
        System.out.printf("%-30s %s", "Days to complete project", ": ");
        days_to_complete = input.nextInt();

        // output variables
        int truckloads, stoplights, conduits;
        double crew_members, cost_asphalt, cost_stoplight, cost_conduit, cost_labor, cost_total;

        // truckloads from road volume (ft^3), cost of asphalt
        double length = length_of_road * MILE;
        double width = ROAD_WIDTH * number_of_lanes;
        double height = asphalt_depth / 12.0;
        double volume = (length * width * height) * ASPHALT_WEIGHT;
        double exact_truckloads = volume / MAX_LOAD;
        truckloads = (int) Math.ceil(exact_truckloads);
        cost_asphalt = truckloads * 1000;

        // number of stoplights & cost
        int stoplights_per_mile = 2 + number_of_lanes;
        stoplights = stoplights_per_mile * (int) length_of_road;
        cost_stoplight = stoplights * STOPLIGHT_COST;

        // amount of conduit pipes needed & cost
        conduits = ((int) length / (int) CONDUIT_LENGTH);
        cost_conduit = conduits * CONDUIT_COST;

        // determining how many crew members are needed, cost of labor
        crew_members = (50 * length_of_road * number_of_lanes) / days_to_complete;
        int crew_final = (int) Math.ceil(crew_members);
        cost_labor = days_to_complete * WORK_DAY * WORK_RATE * crew_final;

        // total final cost
        cost_total = cost_asphalt + cost_conduit + cost_labor + cost_stoplight;


        // OUTPUT:
        // spacing formatted with string methods

        // materials needed
        System.out.println("=== Amount of materials needed ===");
        System.out.printf("%-21s %s %n", "Truckloads of Asphalt", ": " + truckloads);
        System.out.printf("%-21s %s %n", "Stoplights", ": " + stoplights);
        System.out.printf("%-21s %s %n", "Conduit pipes", ": " + conduits);
        System.out.printf("%-21s %s %n", "Crew members needed", ": " + crew_final);
        // cost
        System.out.println("=== Cost of Materials ============");
        NumberFormat cents = new DecimalFormat("#0.00"); // formats costs to reflect decimals in hundreds
        System.out.printf("%-21s %s %n", "Cost of Asphalt", ": $" + cents.format(cost_asphalt));
        System.out.printf("%-21s %s %n", "Cost of Stoplights", ": $" + cents.format(cost_stoplight));
        System.out.printf("%-21s %s %n", "Cost of Conduit pipes", ": $" + cents.format(cost_conduit));
        System.out.printf("%-21s %s %n", "Cost of Labor", ": $" + cents.format(cost_labor));
        // total cost
        System.out.println("=== Total Cost of Project ========");
        System.out.printf("%-21s %s %n", "Total cost of project", ": $" + cents.format(cost_total));


    }
}