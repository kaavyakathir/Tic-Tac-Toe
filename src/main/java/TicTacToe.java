import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        printBoard(board);

        // UC2
        tossAndAssignSymbols();
        displayTossResult();

        // UC3 + UC4 + UC5 combined
        while (true) {
            int slot = getUserSlot();

            int[] position = convertSlotToPosition(slot);
            int row = position[0];
            int col = position[1];

            // UC5 validation
            if (isValidMove(board, row, col)) {
                board[row][col] = humanSymbol;
                break; // valid move → exit loop
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        // Show updated board
        printBoard(board);
    }

    // Print Board
    static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC2: Toss
    static void tossAndAssignSymbols() {
        Random random = new Random();

        int toss = random.nextInt(2);

        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    static void displayTossResult() {
        System.out.println("=== Toss Result ===");

        if (isHumanTurn) {
            System.out.println("Human plays first.");
        } else {
            System.out.println("Computer plays first.");
        }

        System.out.println("Human Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }

    // UC3: Input
    static int getUserSlot() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        return scanner.nextInt();
    }

    // UC4: Convert slot
    static int[] convertSlotToPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Validate move
    static boolean isValidMove(char[][] board, int row, int col) {

        // Check bounds
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}