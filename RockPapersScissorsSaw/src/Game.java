import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

class Game {

    protected int[][] results = {{0,1,-1,-1},{-1,0,1,1},{1,-1,0,1},{1,-1,-1,0}};

    public void rules(){

        System.out.println("Rules:\n1. You can play however many games as you'd like.");
        System.out.println("2. Each game will last 3 rounds.");
        System.out.println("3. Winner of the game against the computer is one who won more rounds");
        System.out.println("4. Overall human winner is based on the greater number of won games against the computer and least games lost");
        System.out.println("5. Rock breaks scissors and Saw therefore rock wins over scissors and saw.Rock loses against paper.");
        System.out.println("6. Scissors cut paper therefore scissors win over paper.Scissors lose against rock and saw.");
        System.out.println("7. Paper covers rock therefore paper wins over rock.Paper loses against scissors and saw.");
        System.out.println("8. Saw cuts through scissors and paper therefore saw wins over scissors and paper.Saw loses against rock.");
        System.out.println("9. If player and computer make the same selection, there is a tie");
        System.out.println("Press Enter to continue...");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        GameDriver.displayMenu();
        GameDriver.selectMenu();
    }
    public void play_game(Player p1, Player p2, int round_counter) {

        do {
            System.out.println(p1.name + " make a selection:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissor");
            System.out.println("4. Saw");
            Scanner in = new Scanner(System.in);


            try {

                p1.input = in.nextInt();
                if (p1.input < 1 || p1.input > 4)

                    System.out.println("Error ,number outside range");

                } catch (InputMismatchException e) {
                    System.out.println("Error, you did not input a number");
                    in.next();
                }
        }while (p1.input < 1 || p1.input > 4) ;


        do {
            System.out.println(p2.name + " make a selection:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissor");
            System.out.println("4. Saw");
            Scanner in = new Scanner(System.in);


            try {

                p2.input = in.nextInt();
                if (p2.input < 1 || p2.input > 4)

                    System.out.println("Error ,number outside range");

            } catch (InputMismatchException e) {
                System.out.println("Error, you did not input a number");
                in.next();
            }
        }while (p2.input < 1 || p2.input > 4) ;

        Random rnd = new Random();
        int ai_input = rnd.nextInt(4)+1;
        if(ai_input == 1)
        System.out.println("\nAI played rock");
        else if (ai_input == 2)
        System.out.println("\nAI played paper");
        else if (ai_input == 3)
            System.out.println("\nAI played scissor");
        else
            System.out.println("\nAI played saw");


        round_counter +=1;
        round_check(p1,p2,ai_input,round_counter);
    }

    public void round_check(Player p1,Player p2,int ai_input,int round_counter){
        //player1 check
        if(p1.input-1 == ai_input-1)
        {
        System.out.println(p1.name + " Tied");
        p1.round[2] += 1;
        p1.stats[2] += 1;
        }
        else if(results[ai_input -1][p1.input-1] == 1){
            System.out.println(p1.name + " Won");
        p1.round[0] += 1;
        p1.stats[0] += 1;
        }
        else {
                System.out.println(p1.name + " Lost");
                p1.round[1] += 1;
                p1.stats[1] += 1;
            }

    //p2Check
        if(p2.input-1 == ai_input-1)
            {
                System.out.println(p2.name + " Tied");
                p2.round[2] += 1;
                p2.stats[2] += 1;
            }
        else if(results[ai_input -1][p2.input-1] == 1){
            System.out.println(p2.name + " Won");
            p2.round[0] += 1;
            p2.stats[0] += 1;
        }
        else {
            System.out.println(p2.name + " Lost");
            p2.round[1] += 1;
            p2.stats[1] += 1;
        }

        if(round_counter == 3) {
            game_check(p1, p2 );
        }

        System.out.println("Press Enter to continue...");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        play_game(p1,p2,round_counter);
        }

    public void game_check(Player p1,Player p2){
        if(p1.round[0] > p2.round[0])
            {p1.stats[3] +=1;
            p2.stats[4] += 1;
            System.out.println(p1.name + " won this game");
            }
        else if(p1.round[0] < p2.round[0])
            {
            p2.stats[3] += 1;
            p1.stats[4] += 1;
            System.out.println(p2.name + " won this game");
            }
        else if(p1.round[1] == p2.round[1])
            {
            p1.stats[5] += 1;
            p2.stats[5] += 1;
            System.out.println("Players tied this game");
            }
        else {
            if (p1.round[1] > p2.round[1])
                {
                    p1.stats[4] += 1;
                    p2.stats[3] += 1;
                    System.out.println(p2.name +  " won this game");
                }
            else {
                p1.stats[3] += 1;
                p2.stats[4] += 1;
                System.out.println(p1.name + " won this game");
                }
            }

        p1.round = new int[] {0,0,0};
        p2.round = new int[] {0,0,0};
        System.out.println("Press Enter to continue...");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        GameDriver.displayMenu();
        GameDriver.selectMenu();
    }
}


