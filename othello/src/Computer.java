public class Computer implements Player {
    @Override
    public boolean putDisc(boolean CanEdit, int x, int y) {
        return false;
    }

    @Override
    public boolean checkCanPut() {
        return false;
    }
}
