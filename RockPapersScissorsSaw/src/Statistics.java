import java.util.Scanner;

public class Statistics {


    public void display(Player p1, Player p2){

        System.out.println(p1.name + " Statistics:");
        System.out.println("Rounds: " + p1.stats[0] + " Wins, " + p1.stats[1] + " Losses, " + p1.stats[2] + " Ties" );
        System.out.println("Games: " + p1.stats[3] + " Wins, " + p1.stats[4] + " Losses, " + p1.stats[5] + " Ties\n" );
        System.out.println(p2.name + " Statistics:");
        System.out.println("Rounds: " + p2.stats[0] + " Wins, " + p2.stats[1] + " Losses, " + p2.stats[2] + " Ties" );
        System.out.println("Games: " + p2.stats[3] + " Wins, " + p2.stats[4] + " Losses, " + p2.stats[5] + " Ties\n" );

        if(p1.stats[3] > p2.stats[3]) {
            System.out.println(p1.name + " is Winning");
        }
        else if(p1.stats[3] < p2.stats[3]) {
            System.out.println(p2.name + " is Winning");
        }
        else if(p1.stats[4] == p2.stats[4]) {
            System.out.println("Players are tied");
        }
        else {
            if(p1.stats[4] > p2.stats[4]) {
                System.out.println(p2.name + " is Winning");
            }
            else {
                System.out.println(p1.name +  " is Winning");
            }
        }
        System.out.println("Press Enter to continue...");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        GameDriver.displayMenu();
        GameDriver.selectMenu();
    }
}
