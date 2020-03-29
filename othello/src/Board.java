/**
 * this game needs a board to put discs in it this class provides this goal for us
 */
public class Board {
    //the board is a 10*10 array of Disc , it is 10*10 in the propose of not exiting the 8*8 map
    private static Disc[][] board = new Disc[10][10];

    /**
     * type -1 means there must be no disc here
     * type 0 means this place is empty
     * type 1 means this place is for player 1
     * type 2 means this place is for player 2
     */
    public Board() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    board[i][j] = new Disc(-1);
                } else if (i == 4 && j == 4) {
                    board[i][j] = new Disc(2);
                } else if (i == 4 && j == 5) {
                    board[i][j] = new Disc(1);
                } else if (i == 5 && j == 5) {
                    board[i][j] = new Disc(2);
                } else if (i == 5 && j == 4) {
                    board[i][j] = new Disc(1);
                } else
                    board[i][j] = new Disc(0);
            }
    }

    /**
     * it prints the details of board
     */
    public static void printBoard() {
        System.out.println();
        System.out.println("\t Player 1 points: "+pointCounter(1) + "   ||   Player 2 points: "+pointCounter(2));
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j].getType() == 0) {
                    System.out.print('\u22C5' + "     ");
                } else if (board[i][j].getType() == -1) {
                    if((i == 0 && j == 0) ||(i == 0 && j ==9)||(i ==9 && j ==9 ) || (i == 9 && j ==0) ) System.out.print("#    ");
                    else if (i == 0 || i == 9) System.out.print((char) ('\u24B6'+j-1)+""+"    ");
                    else if (j == 0 || j== 9) System.out.print((char) ('\u2474'+i-1)+""+"    ");
                }
                else if (board[i][j].getType() == 1)
                    System.out.print('\u26AA' + "    ");
                else if (board[i][j].getType() == 2)
                    System.out.print('\u26AB' + "    ");
            }
            System.out.println("\n");
        }
    }

    /**
     * get the board of the game
     * @return board
     */
    public static Disc[][] getBoard() {
        return board;
    }

    /**
     * it calculate how many points each player has caught
     * @param type type of player to count
     * @return the number of points of player
     */
    public static int pointCounter(int type){
        int player1Points = 0;
        int player2Points = 0;
        for (int i = 0 ; i < 10 ; i++ )
            for (int j = 0 ;  j < 10 ; j++) {
                if (type == 1 && board[i][j].getType() == 1) player1Points++;
                else if(type == 2 && board[i][j].getType() == 2)player2Points++;
            }
        if (type == 1)return player1Points;
        else return  player2Points;
    }
}
