import java.util.Scanner;
public class Main
{

    public static void main(String[] args)
    {
        String player1;
        String player2;
        Scanner in = new Scanner(System.in);
        String playResponse;
        boolean keepPlaying = true;

        while (keepPlaying)
        {
            System.out.println();
            System.out.println("NEW GAME");
            //player 1 input
            do
            {
                System.out.println("Input your choice player 1 [R, P, or S]");
                player1 = in.nextLine();
            } while (!(player1.equalsIgnoreCase("R") || player1.equalsIgnoreCase("P") || player1.equalsIgnoreCase("S")));

            //player 2 input
            do
            {
                System.out.println("Input your choice player 2 [R, P, or S]");
                player2 = in.nextLine();
            } while (!(player2.equalsIgnoreCase("R") || player2.equalsIgnoreCase("P") || player2.equalsIgnoreCase("S")));

            //game logic
            if (player1.equalsIgnoreCase("R"))
            {
                if (player2.equalsIgnoreCase("R"))
                {
                    System.out.println("Rock ties with Rock, it's a tie!");
                }
                else if (player2.equalsIgnoreCase("P"))
                {
                    System.out.println("Paper covers Rock, player 2 wins!");
                }
                else if (player2.equalsIgnoreCase("S"))
                {
                    System.out.println("Rock breaks Scissors, player 1 wins!");
                }

            }
            else if (player1.equalsIgnoreCase("P"))
            {
                if (player2.equalsIgnoreCase("R"))
                {
                    System.out.println("Paper covers Rock, player 1 wins!");
                }
                else if (player2.equalsIgnoreCase("P"))
                {
                    System.out.println("Paper ties with Paper, it's a tie!");
                }
                else if (player2.equalsIgnoreCase("S"))
                {
                    System.out.println("Scissors cuts paper, player 2 wins!");
                }
            }
            else if (player1.equalsIgnoreCase("S"))
            {
                if (player2.equalsIgnoreCase("R"))
                {
                    System.out.println("Rock breaks Scissors, player 2 wins!");
                }
                else if (player2.equalsIgnoreCase("P"))
                {
                    System.out.println("Scissors cuts paper, player 1 wins!");
                }
                else if (player2.equalsIgnoreCase("S"))
                {
                    System.out.println("Scissors ties with Scissors, it's a tie!");
                }
            }

            System.out.println("Do you want to keep playing: [Y/N]");
            playResponse = in.nextLine();
            if (playResponse.equalsIgnoreCase("N"))
            {
                System.exit(0);
            }
        }
    }
}