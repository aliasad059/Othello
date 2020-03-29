import java.util.HashMap;

public class Human implements Player{
    private int type;

    public Human(int type) {
        this.type = type;
    }

    public boolean putDisc(boolean CanEdit, int x, int y) {
        Disc[][] board = Board.getBoard();
        //checking if this coordinate is empty
        if (x > 0 && x < 9 && y > 0 && y < 9) {
            if (board[x][y].getType() == 0) {

                boolean ifPut = false;
                boolean ifChange = false;
                int moveToNorth = 0, moveToEast = 0, moveToSouth = 0, moveToWest = 0;
                //checking if two disc of human surrounds opponent's disc if yes then update board according to starting disc


                //////////////////////////////////////
                ////checking and changing east of starting disc
                //////////////////////////////////////

                for (moveToEast = 1; moveToEast < 10; moveToEast++) {
                    if (x + moveToEast > 9) break;
                    if (board[x + moveToEast][y].getType() != type && board[x + moveToEast][y].getType() != -1) {
                        if (board[x + moveToEast][y].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x + moveToEast][y].getType() == type) {
                        if (moveToEast == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToEast; i++)
                        board[x + i][y].setType(type);
                }

                //////////////////////////////////////
                ////checking and changing west of starting disc
                //////////////////////////////////////

                ifChange = false;
                for (moveToWest = 1; moveToWest < 9; moveToWest++) {
                    if (x - moveToWest < 0) break;
                    if (board[x - moveToWest][y].getType() != type && board[x - moveToWest][y].getType() != -1) {
                        if (board[x - moveToWest][y].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x - moveToWest][y].getType() == type) {
                        if (moveToWest == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToWest; i++)
                        board[x - i][y].setType(type);
                }

                //////////////////////////////////////
                ////checking and changing north of starting disc
                //////////////////////////////////////

                ifChange = false;
                for (moveToSouth = 1; moveToSouth < 9; moveToSouth++) {
                    if (y - moveToSouth < 0) break;
                    if (board[x][y - moveToSouth].getType() != type && board[x][y - moveToSouth].getType() != -1) {
                        if (board[x][y - moveToSouth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x][y - moveToSouth].getType() == type) {
                        if (moveToSouth == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToSouth; i++)
                        board[x][y - i].setType(type);
                }

                //////////////////////////////////////
                ////checking and changing north of starting disc
                //////////////////////////////////////

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
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToNorth; i++)
                        board[x][y + i].setType(type);
                }

                //////////////////////////////////////
                ////checking and changing north- east of starting disc
                //////////////////////////////////////


                ifChange = false;
                for (moveToNorth = 1, moveToEast = 1; moveToNorth < 9; moveToNorth++, moveToEast++) {
                    if (y + moveToNorth > 9 || x + moveToEast > 9) break;
                    if (board[x + moveToEast][y + moveToNorth].getType() != type && board[x + moveToEast][y + moveToNorth].getType() != -1) {
                        if (board[x + moveToEast][y + moveToNorth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x + moveToEast][y + moveToNorth].getType() == type) {
                        if (moveToEast == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToNorth; i++)
                        board[x + i][y + i].setType(type);
                }
                //////////////////////////////////////
                ////checking and changing north- west of starting disc
                //////////////////////////////////////

                ifChange = false;
                for (moveToNorth = 1, moveToWest = 1; moveToNorth < 9; moveToNorth++, moveToWest++) {
                    if (x - moveToWest < 0 || y + moveToNorth > 9) break;
                    if (board[x - moveToWest][y + moveToNorth].getType() != type && board[x - moveToWest][y + moveToNorth].getType() != -1) {
                        if (board[x - moveToWest][y + moveToNorth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x - moveToWest][y + moveToNorth].getType() == type) {
                        if (moveToWest == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToNorth; i++)
                        board[x - i][y + i].setType(type);
                }

                //////////////////////////////////////
                ////checking and changing south- east of starting disc
                //////////////////////////////////////


                ifChange = false;
                for (moveToSouth = 1, moveToEast = 1; moveToSouth < 9; moveToSouth++, moveToEast++) {
                    if (y - moveToSouth < 0 || x + moveToEast > 9) break;
                    if (board[x + moveToEast][y - moveToSouth].getType() != type && board[x + moveToEast][y - moveToSouth].getType() != -1) {
                        if (board[x + moveToEast][y - moveToSouth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x + moveToEast][y - moveToSouth].getType() == type) {
                        if (moveToEast == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToSouth; i++)
                        board[x + i][y - i].setType(type);
                }

                //////////////////////////////////////
                ////checking and changing north- east of starting disc
                //////////////////////////////////////


                ifChange = false;
                for (moveToSouth = 1, moveToWest = 1; moveToSouth < 9; moveToSouth++, moveToWest++) {
                    if (x - moveToWest < 0 || y - moveToSouth < 0) break;
                    if (board[x - moveToWest][y - moveToSouth].getType() != type && board[x - moveToWest][y - moveToSouth].getType() != -1) {
                        if (board[x - moveToWest][y - moveToSouth].getType() == 0) {
                            ifChange = false;
                            break;
                        }
                    } else if (board[x - moveToWest][y - moveToSouth].getType() == type) {
                        if (moveToWest == 1) break;
                        ifChange = true;
                        ifPut = true;
                        break;
                    }
                }
                if (CanEdit && ifChange) {
                    for (int i = 0; i <= moveToSouth; i++)
                        board[x - i][y - i].setType(type);
                }

                return ifPut;

            } else {
                //System.out.println("can not put here");
                return false;
            }
        }
        else return false;
    }

    public boolean checkCanPut() {
        boolean passTurn = false;
        for (int i = 1; i < 9; i++)
            for (int j = 1; j < 9; j++) {
                passTurn = passTurn || putDisc(false, i, j);
            }
        return passTurn;
    }
}
