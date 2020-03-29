import java.util.Scanner;

public class Game {
    public static void startMultiMod() {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Human human1 = new Human(1);
        Human human2 = new Human(2);
        boolean human1HasTurn = true;
        boolean human2HasTurn = true;
        while (true) {
            while (true) {
                board.printBoard();
                System.out.println("Human 1 turn");
                String string1 = scanner.nextLine();
                int y = string1.charAt(0) - 64;
                int x = string1.charAt(2) - 48;
                boolean passTurn = human1.checkCanPut();

                if (!passTurn) {
                    human1HasTurn = false ;
                    System.out.println("Pass");
                    break;
                }
                else if (human1.putDisc(true, x, y)) {
                    human1HasTurn = true ;
                    break;
                }
                else System.out.println("Can not put here choose another coordinate");
            }
            while (true) {
                board.printBoard();
                System.out.println("Human 2 turn");
                String string2 = scanner.nextLine();
                int y = string2.charAt(0) - 64;
                int x = string2.charAt(2) - 48;
                boolean passTurn = human2.checkCanPut();
                //boolean passTurn = true;
                if (!passTurn) {
                    human2HasTurn = false;
                    System.out.println("Pass");
                    break;
                }
                else if (human2.putDisc(true, x, y)) {
                    human2HasTurn = true;
                    break;
                }
                else System.out.println("Can not put here choose another coordinate");
            }
            if (!(human1HasTurn || human2HasTurn)) {
                System.out.println("The game has finished!");
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
    public static void startSoloMod() {}

        public static void main(String[] args) {
        startMultiMod();
    }
}
