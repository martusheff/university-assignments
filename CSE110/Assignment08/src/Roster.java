// CSE 110     : CSE110 Session A
// Assignment  : Assignment08
// Author      : Andronick Martusheff - 1219284898
// Description : Roster file for Assignment08

import java.util.ArrayList;
import java.io.*;

public class Roster {

    private ArrayList<Player>players;


    public Roster(){ // creates roster object
        ArrayList<Player>players = new ArrayList<Player>();
        this.players = players;
    }

    public Roster(String fileName)throws IOException { // reads roster
        ArrayList<Player>players = new ArrayList<Player>();
        this.players = players;
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); //reads file
        String line;

        while ((line = reader.readLine()) != null){
            String[] splitArray = line.split("\\s+");
            Player player = new Player(splitArray[0] + " " +  splitArray[1], Double.parseDouble(
                    splitArray[2]),Double.parseDouble(splitArray[3]));
            players.add(player);
        }
    }

    public void addPlayer(String name, double attackStat, double blockStat) { //adds player from input
        Player player = new Player(name, attackStat, blockStat);
        this.players.add(player);
    }

    public int countPlayers(){
        return this.players.size();
    } // counts length of array list

    public Player getPlayerByName(String name) { // searches for player in enhanced loop
        for(Player player: players) {
            if(player.getName().equals(name)){ // if the specified name is .equals(target), returns player
                return player;
            }
        }
        return null;
    }

    public void printTopAttackers() { // finds top attacker
        double top1 = 0.0, top2 = 0.0, curr;
        for(Player player: players) { //for player in players,
            curr = player.getAttackStat(); // curr is the current attack stat @ index of player
            if(top1 < curr){ // if the current player score is greater than the top score, update the current top score
                top2 = top1; // updates
                top1 = curr; // updates
            } else if(top2 < curr){ // if the 2nd score is less than the current score, update the new 2nd score
                top2 = curr;
            }
        }

        for(Player player: players) {
            if(player.getAttackStat() == top1) { // returns all player info for the player with the top attack stat
                player.printPlayerInfo();
            }
        }
        for(Player player: players) {
            if(player.getAttackStat() == top2) { // same as above, but for 2nd
                player.printPlayerInfo();
            }
        }
    }

    public void printTopBlockers() {
        double top1 = 0.0, top2 = 0.0, curr; // similar approach, only for block score
        for(Player player: players) {
            curr = player.getBlockStat();
            if(top1 < curr){
                top2 = top1;
                top1 = curr;
            } else if(top2 < curr){
                top2 = curr;
            }
        }

        for(Player player: players) {
            if(player.getBlockStat() == top1) {
                player.printPlayerInfo();
            }
        }

        for(Player player: players) {
            if(player.getBlockStat() == top2) {
                player.printPlayerInfo();
            }
        }
    }
    public void printAllPlayers() { // iterates through all players, prints info
        for(Player player: players) {
            player.printPlayerInfo();
        }
    }
}