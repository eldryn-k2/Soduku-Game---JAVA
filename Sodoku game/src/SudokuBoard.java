public class SudokuBoard {
    private SudokuCell[][] board;

    public SudokuBoard() {
        board = new SudokuCell[9][9];
        generateBoard();
    }

    private void generateBoard() {
        // Simples exemplo com alguns valores fixos
        int[][] preset = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean isFixed = preset[i][j] != 0;
                board[i][j] = new SudokuCell(preset[i][j], isFixed);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                int val = board[i][j].getValue();
                System.out.print(val == 0 ? ". " : val + " ");
            }
            System.out.println();
        }
    }

    public boolean setValue(int row, int col, int value) {
        if (isValid(row, col, value)) {
            board[row][col].setValue(value);
            return true;
        }
        return false;
    }

    private boolean isValid(int row, int col, int value) {
        if (value < 1 || value > 9) return false;

        // Verifica linha e coluna
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getValue() == value || board[i][col].getValue() == value) {
                return false;
            }
        }

        // Verifica bloco 3x3
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j].getValue() == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
