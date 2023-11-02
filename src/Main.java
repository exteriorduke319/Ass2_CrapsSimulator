import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dice1;
        int dice2;
        int sum;
        int point;
        String doneCheck;
        boolean done;
        boolean playAgain = true;
        boolean rerolls;


        System.out.println("Welcome to the craps simulator!  Here's the rules: ");
        System.out.println("1. There is an initial roll of 2 dice resulting in a sum of 2 – 12.");
        System.out.println("2. If the sum is 2, 3, or 12 it is called \"craps\" or \"crapping out\" and the game is over with a loss.");
        System.out.println("3. If the sum is 7 or 11 it is called a \"natural\" and the game is over with a win.");
        System.out.println("4. For all other values, the sum becomes \"the point\" and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win.");
        System.out.println("5. After a win or loss, the next player rolls the die for a new game. ");
        System.out.println();

        while(playAgain) {
            done = false;
            rerolls = true;
            while (!done) {
                dice1 = (int) (Math.random() * 6) + 1;
                dice2 = (int) (Math.random() * 6) + 1;
                point = dice1 + dice2;

                System.out.println("Roll 1: " + dice1);
                System.out.println("Roll 2: " + dice2);
                System.out.println("Sum: " + point);

                if (point == 7 || point == 11) {
                    System.out.println("You win!");
                    done = true;
                } else if (point == 2 || point == 3 || point == 12) {
                    System.out.println("Craps! You lose.");
                    done = true;
                } else {
                    while (rerolls) {
                        System.out.println("Re-roll.  You must roll a " + point + " to win.  A 7 will result in a loss.");
                        System.out.println();

                        dice1 = (int) (Math.random() * 6) + 1;
                        dice2 = (int) (Math.random() * 6) + 1;
                        sum = dice1 + dice2;

                        System.out.println("Roll 1: " + dice1);
                        System.out.println("Roll 2: " + dice2);
                        System.out.println("Sum: " + sum);

                        if (dice1 + dice2 == point) {
                            System.out.println("You win!");
                            rerolls = false;
                            done = true;
                        } else if (dice1 + dice2 == 7) {
                            System.out.println("You lost!");
                            rerolls = false;
                            done = true;
                        }
                    }
                }
            }
            System.out.println();
            System.out.print("Play again? Y or N: ");
            doneCheck = scan.nextLine();
            if (doneCheck.equalsIgnoreCase("n")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }
    }
}

