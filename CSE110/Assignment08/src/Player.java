// CSE 110     : CSE110 Session A
// Assignment  : Assignment08
// Author      : Andronick Martusheff - 1219284898
// Description : Player file for Assignment08

public class Player {
    private String name;
    private double attackStat, blockStat;


    public Player(String name, double attackStat, double blockStat) { // creates new player
        this.name = name;
        this.attackStat = attackStat;
        this.blockStat = blockStat;
    }

    public String getName() {
        return name;
    } // gets player name

    public double getAttackStat() {
        return attackStat;
    } //gets players attack stat

    public void setAttackStat(double attackStat){
        this.attackStat = attackStat;
    } // updates players attack stat

    public double getBlockStat() {
        return blockStat;
    } // gets players block stat

    public void setBlockStat(double blockStat) {
        this.blockStat = blockStat;
    } // updates players block stat

    public void printPlayerInfo() { // prints player info (name & stats)
        System.out.println(name + " (attack = " + attackStat + ", block = " + blockStat+")");
    }

}