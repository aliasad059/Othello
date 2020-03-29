/**
 * this class provides us the disc of game
 */
public class Disc {
    /**
     * type -1 means there must be no disc here
     * type 0 means this place is empty
     * type 1 means this place is for player 1
     * type 2 means this place is for player 2
     */
    private int type;

    public Disc(int type) {
        this.type = type;
    }

    /**
     * get the type of disc
     * @return type of disc
     */
    public int getType() {
        return type;
    }

    /**
     * set a new type for the disc
     * @param type the new type
     */
    public void setType(int type) {
        this.type = type;
    }
}
