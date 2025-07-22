import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;
    private Scanner scanner;

    public SudokuGame() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Bem-vindo ao Sudoku! ===");
        while (true) {
            board.printBoard();
            System.out.print("Digite linha (0-8), coluna (0-8) e valor (1-9), separados por espaço: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int value = scanner.nextInt();

            if (row == -1 || col == -1 || value == -1) {
                System.out.println("Saindo do jogo.");
                break;
            }

            boolean success = board.setValue(row, col, value);
            if (!success) {
                System.out.println("Movimento inválido! Tente novamente.");
            }
        }
    }
}
