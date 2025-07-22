public class SudokuCell {
    private int value;
    private boolean isFixed;

    public SudokuCell(int value, boolean isFixed) {
        this.value = value;
        this.isFixed = isFixed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (!isFixed) {
            this.value = value;
        }
    }

    public boolean isFixed() {
        return isFixed;
    }
}
