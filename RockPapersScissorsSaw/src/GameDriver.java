
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameDriver {

    //Global variables
    public static int round_counter = 0;

    // Instance of classes
    static Game myGame = new Game();
    static Player player1 = new Player();
    static Player player2 = new Player();
    static Statistics stats = new Statistics();


    public static void main(String[] args) {

        setPlayers();  //Asks and assigns human players names , values are stored in p1 and p2 variables
        displayMenu(); //displays menu
        selectMenu();  //makes selection and call game

    }

    public static void setPlayers() {

        System.out.println("\nWelcome to the Rock Papers Scissors Saw game\n");
        System.out.println("\nWhat is the new name of the first player?:\n");
        Scanner myObj1 = new Scanner(System.in);
        player1.name = myObj1.nextLine();

        while (player1.name.length() < 5 || player1.name.length() > 20) {
            System.out.println("Please keep it from 5 to 20 characters");
            player1.name = myObj1.nextLine();
        }


        System.out.println("\nWhat is the new name of the second player?:\n");
        Scanner myObj2 = new Scanner(System.in);
        player2.name = myObj2.nextLine();

        while (player2.name.length() < 5 || player2.name.length() > 20 || player2.name.equals(player1.name)) {
            if (player2.name.length() < 5 || player2.name.length() > 20) {
                System.out.println("Please keep it from 5 to 20 characters");
            } else {
                System.out.println("Player 2 name must be different from Player 1 name.");
            }
            player2.name = myObj2.nextLine();
        }


    }

    public static void displayMenu() {
        System.out.println("\nPress the corresponding key to continue:");
        System.out.println("1. Start Playing");
        System.out.println("2. Rules");
        System.out.println("3. Statistics");
        System.out.println("4. Exit");
    }

    public static void selectMenu() {

        Scanner in = new Scanner(System.in);
        int menuInput = 0;

        do {
            try {
                menuInput = in.nextInt();
                if (menuInput < 1 || menuInput > 4) {
                    System.out.println("Error");
                    System.out.println("\nPress the corresponding key to continue:");
                    System.out.println("1. Start Playing");
                    System.out.println("2. Rules");
                    System.out.println("3. Statistics");
                    System.out.println("4. Exit");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, you did not input a number");
                in.next();
            }
        } while (menuInput < 1 || menuInput > 4);


        switch (menuInput) {
            case 1 -> myGame.play_game(player1, player2, round_counter);

            case 2 -> myGame.rules();

            case 3 -> stats.display(player1, player2);

            case 4 -> {
                System.out.println("Goodbye...");
                System.exit(0);
            }
        }
    }
}






