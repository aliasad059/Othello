/**
 * provides a human for the game
 */
public class Human implements Player {
    private int type;

    public Human(int type) {
        this.type = type;
    }

    /**
     * this method helps us in two way the more important one put the disc in the board in other word it changes the board,
     * and the next one is that it helps us for some checking that are explained in its place.
     * @param canEdit if yes it can change the board
     * @param x the x of disc
     * @param y the y of disc
     * @return return true if successfully put
     */

    public boolean putDisc(boolean canEdit, int x, int y) {
        Disc[][] board = Board.getBoard();
        //checking if this coordinate is empty and valid
        if (x > 0 && x < 9 && y > 0 && y < 9) {
            if (board[x][y].getType() == 0) {
                // ifPut helps us to see if there is no way of move or not in all the directions
                boolean ifPut = false;
                // it lets changing the program if found any way in each direction separately
                boolean ifChange = false;

                int moveToNorth = 0, moveToEast = 0, moveToSouth = 0, moveToWest = 0;

                ///////////////////////////////////////////////////
                ////checking and changing east of starting disc////
                ///////////////////////////////////////////////////

                for (moveToEast = 1; moveToEast < 10; moveToEast++) {
                    if (x + moveToEast > 9) break;
                    if (board[x + moveToEast][y].getType() != type && board[x + moveToEast][y].getType() != -1) {
                        if (board[x + moveToEast][y].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                        //if it hits disc with the same type it means that it is enough in this direction and the changes should be done
                    } else if (board[x + moveToEast][y].getType() == type) {
                        if (moveToEast == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToEast; i++)
                        board[x + i][y].setType(type);
                }

                ///////////////////////////////////////////////////
                ////checking and changing west of starting disc////
                ///////////////////////////////////////////////////

                ifChange = false;
                for (moveToWest = 1; moveToWest < 9; moveToWest++) {
                    if (x - moveToWest < 0) break;
                    if (board[x - moveToWest][y].getType() != type && board[x - moveToWest][y].getType() != -1) {
                        if (board[x - moveToWest][y].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                        //if it hits disc with the same type it means that it is enough in this direction and the changes should be done
                    } else if (board[x - moveToWest][y].getType() == type) {
                        if (moveToWest == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToWest; i++)
                        board[x - i][y].setType(type);
                }

                ////////////////////////////////////////////////////
                ////checking and changing north of starting disc////
                ////////////////////////////////////////////////////

                ifChange = false;
                for (moveToSouth = 1; moveToSouth < 9; moveToSouth++) {
                    if (y - moveToSouth < 0) break;
                    if (board[x][y - moveToSouth].getType() != type && board[x][y - moveToSouth].getType() != -1) {
                        if (board[x][y - moveToSouth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                        //if it hits disc with the same type it means that it is enough in this direction and the changes should be done

                    } else if (board[x][y - moveToSouth].getType() == type) {
                        if (moveToSouth == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToSouth; i++)
                        board[x][y - i].setType(type);
                }

                ////////////////////////////////////////////////////
                ////checking and changing north of starting disc////
                ////////////////////////////////////////////////////

                ifChange = false;
                for (moveToNorth = 1; moveToNorth < 9; moveToNorth++) {
                    if (y + moveToNorth > 9) break;
                    if (board[x][y + moveToNorth].getType() != type && board[x][y + moveToNorth].getType() != -1) {
                        if (board[x][y + moveToNorth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x][y + moveToNorth].getType() == type) {
                        if (moveToNorth == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToNorth; i++)
                        board[x][y + i].setType(type);
                }

                //////////////////////////////////////////////////////////
                ////checking and changing north- east of starting disc////
                //////////////////////////////////////////////////////////


                ifChange = false;
                for (moveToNorth = 1, moveToEast = 1; moveToNorth < 9; moveToNorth++, moveToEast++) {
                    if (y + moveToNorth > 9 || x + moveToEast > 9) break;
                    if (board[x + moveToEast][y + moveToNorth].getType() != type && board[x + moveToEast][y + moveToNorth].getType() != -1) {
                        if (board[x + moveToEast][y + moveToNorth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                        //if it hits disc with the same type it means that it is enough in this direction and the changes should be done

                    } else if (board[x + moveToEast][y + moveToNorth].getType() == type) {
                        if (moveToEast == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToNorth; i++)
                        board[x + i][y + i].setType(type);
                }
                //////////////////////////////////////////////////////////
                ////checking and changing north- west of starting disc////
                //////////////////////////////////////////////////////////

                ifChange = false;
                for (moveToNorth = 1, moveToWest = 1; moveToNorth < 9; moveToNorth++, moveToWest++) {
                    if (x - moveToWest < 0 || y + moveToNorth > 9) break;
                    if (board[x - moveToWest][y + moveToNorth].getType() != type && board[x - moveToWest][y + moveToNorth].getType() != -1) {
                        if (board[x - moveToWest][y + moveToNorth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                        //if it hits disc with the same type it means that it is enough in this direction and the changes should be done

                    } else if (board[x - moveToWest][y + moveToNorth].getType() == type) {
                        if (moveToWest == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToNorth; i++)
                        board[x - i][y + i].setType(type);
                }

                //////////////////////////////////////////////////////////
                ////checking and changing south- east of starting disc////
                //////////////////////////////////////////////////////////


                ifChange = false;
                for (moveToSouth = 1, moveToEast = 1; moveToSouth < 9; moveToSouth++, moveToEast++) {
                    if (y - moveToSouth < 0 || x + moveToEast > 9) break;
                    if (board[x + moveToEast][y - moveToSouth].getType() != type && board[x + moveToEast][y - moveToSouth].getType() != -1) {
                        if (board[x + moveToEast][y - moveToSouth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                        //if it hits disc with the same type it means that it is enough in this direction and the changes should be done

                    } else if (board[x + moveToEast][y - moveToSouth].getType() == type) {
                        if (moveToEast == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToSouth; i++)
                        board[x + i][y - i].setType(type);
                }

                //////////////////////////////////////////////////////////
                ////checking and changing north- east of starting disc////
                //////////////////////////////////////////////////////////


                ifChange = false;
                for (moveToSouth = 1, moveToWest = 1; moveToSouth < 9; moveToSouth++, moveToWest++) {
                    if (x - moveToWest < 0 || y - moveToSouth < 0) break;
                    if (board[x - moveToWest][y - moveToSouth].getType() != type && board[x - moveToWest][y - moveToSouth].getType() != -1) {
                        if (board[x - moveToWest][y - moveToSouth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                        //if it hits disc with the same type it means that it is enough in this direction and the changes should be done

                    } else if (board[x - moveToWest][y - moveToSouth].getType() == type) {
                        if (moveToWest == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (canEdit && ifChange) {
                    for (int i = 0; i <= moveToSouth; i++)
                        board[x - i][y - i].setType(type);
                }
                //if ifPut is false it means that there is no way to put a disc in the board at the moment
                //so , the turn will be passed to the next player
                return ifPut;
            } else {
                return false;
            }
        } else return false;
    }

    /**
     * check if there is at least one place to put the disc
     * @return false if the is no way of putting in the board so, the turn will be passed
     */
    public boolean checkCanPut() {
        boolean passTurn = false;
        for (int i = 1; i < 9; i++)
            for (int j = 1; j < 9; j++) {
                //making sure that no changes may be happen by using canEdit = false
                passTurn = passTurn || putDisc(false, i, j);
            }
        return passTurn;
    }
}
