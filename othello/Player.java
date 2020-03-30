/**
 * this interface provides the needs of a player , the players are two kind in this game computer and human
 */
public interface Player {
    /**
     * this method helps us in two way the more important one put the disc in the board in other word it changes the board,
     * and the next one is that it helps us for some checking that are explained in its place.
     * @param canEdit if yes it can change the board
     * @param x the x of disc
     * @param y the y of disc
     * @return return true if successfully put
     */
    boolean  putDisc(boolean canEdit, int x, int y);

    /**
     * check if there is at least one place to put the disc
     * @return false if there is no move
     */
    boolean checkCanPut();

}
