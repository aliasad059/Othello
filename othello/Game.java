import java.util.Scanner;

/**
 * this class starts the othello game in two mode
 */
public class Game {
    static Scanner scanner = new Scanner(System.in);

    /**
     * starting the game in multi (2 player mode)
     */
    public static void startMultiMod() {
        System.out.println("Starting MultiMode!");
        System.out.println("Human 1 discs are showed: " + '\u26AA');
        System.out.println("Human 2 discs are showed: " + '\u26AB');
        Board board = new Board();
        Human human1 = new Human(1);
        Human human2 = new Human(2);
        //if non of two players has a turn the game will be finished
        boolean human1HasTurn = true;
        boolean human2HasTurn = true;
        while (true) {
            while (true) {
                //checking if the player can have any putting if not the turn will be passed to the next one
                boolean passTurn = human1.checkCanPut();
                if (!passTurn) {
                    human1HasTurn = false;
                    System.out.println("Pass!");
                    break;
                }
                board.printBoard();
                System.out.println("Human 1 turn "+ '\u26AA');
                String string1 = scanner.nextLine();
                int x=-1, y=-1;
                try {
                    x = string1.charAt(0) - 48;
                    y = string1.charAt(2) - 64;
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Wrong input , try again");
                    continue;
                }

                // if the player did not put the disc successfully, get another coordinate
                if (human1.putDisc(true, x, y)) {
                    human1HasTurn = true;
                    break;
                } else System.out.println("Can not put here choose another coordinate");
            }
            while (true) {
                //checking if the player can have any putting if not the turn will be passed to the next one

                boolean passTurn = human2.checkCanPut();
                if (!passTurn) {
                    human2HasTurn = false;
                    System.out.println("Pass!");
                    break;
                }
                board.printBoard();
                System.out.println("Human 2 turn "+ '\u26AB');
                String string2 = scanner.nextLine();
                int x=-1, y=-1;
                try {
                    x = string2.charAt(0) - 48;
                    y = string2.charAt(2) - 64;

                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Wrong input , try again");
                    continue;
                }

                // if the player did not put the disc successfully, get another coordinate

                if (human2.putDisc(true, x, y)) {
                    human2HasTurn = true;
                    break;
                } else System.out.println("Can not put here choose another coordinate");
            }
            //checking the end of game
            if (!(human1HasTurn || human2HasTurn)) {
                System.out.println("The game has finished!");
                System.out.println("Human 1 caught " + Board.pointCounter(1) + " points");
                System.out.println("Human 2 caught " + Board.pointCounter(2) + " points");

                if (Board.pointCounter(1) > Board.pointCounter(2))
                    System.out.println("Human 1 won the game!");
                else if (Board.pointCounter(1) < Board.pointCounter(2))
                    System.out.println("Human 2 won the game!");
                else if (Board.pointCounter(1) == Board.pointCounter(2))
                    System.out.println("The game drew!");
                break;
            }
        }
    }

    public static void startSoloMod() {
        System.out.println("Starting MultiMode!");
        System.out.println("Human discs are showed:" + '\u26AA');
        System.out.println("Computer discs are showed:" + '\u26AB');

        Board board = new Board();
        Human human = new Human(1);
        Computer computer = new Computer();
        boolean humanHasTurn = true;
        boolean computerHasTurn = true;
        while (true) {
            while (true) {

                //checking if the player can have any putting if not the turn will be passed to the next one
                boolean passTurn = human.checkCanPut();
                if (!passTurn) {
                    humanHasTurn = false;
                    System.out.println("Pass!");
                    break;
                }
                board.printBoard();
                System.out.println("Human turn! "+ '\u26AA');
                String string1 = scanner.nextLine();
                int x=-1, y=-1;
                try {
                    y = string1.charAt(2) - 64;
                    x = string1.charAt(0) - 48;
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Wrong input , try again");
                    continue;
                }
                // if the player did not put the disc successfully, get another coordinate

                if (human.putDisc(true, x, y)) {
                    humanHasTurn = true;
                    break;
                } else System.out.println("Can not put here choose another coordinate");
            }
            while (true) {
                //checking if the player can have any putting if not the turn will be passed to the next one

                boolean passTurn = computer.checkCanPut();
                if (!passTurn) {
                    computerHasTurn = false;
                    System.out.println("Pass!");
                    break;
                }
                board.printBoard();
                System.out.println("Computer turn! "++ '\u26AB');

                if (computer.putDiscComputer()) {
                    computerHasTurn = true;
                    break;
                } else continue;
            }
            //checking the end of game
            if (!(humanHasTurn || computerHasTurn)) {
                System.out.println("The game has finished!");
                System.out.println("Human caught " + Board.pointCounter(1) + " points");
                System.out.println("Computer caught " + Board.pointCounter(2) + " points");
                if (Board.pointCounter(1) > Board.pointCounter(2))
                    System.out.println("Human won the game!");
                else if (Board.pointCounter(1) < Board.pointCounter(2))
                    System.out.println("Computer won the game!");
                else if (Board.pointCounter(1) == Board.pointCounter(2))
                    System.out.println("The game drew!");
                break;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to othello!");
        System.out.println("choose the mode you want to play : SoloMode(1) | MultiMode(2)");
        String mode = scanner.nextLine();
        if (mode.charAt(0) == '1')
            startSoloMod();
        else if (mode.charAt(0) == '2')
            startMultiMod();
    }
}
