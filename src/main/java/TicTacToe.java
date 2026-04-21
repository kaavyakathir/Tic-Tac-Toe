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

        // Display initial board
        printBoard(board);

        // UC2: Toss
        tossAndAssignSymbols();
        displayTossResult();

        // UC3: Get user input
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);

        // UC4: Convert slot to row & column
        int[] position = convertSlotToPosition(slot);
        int row = position[0];
        int col = position[1];

        System.out.println("Row: " + row + ", Column: " + col);

        // Place symbol
        board[row][col] = humanSymbol;

        // Display updated board
        printBoard(board);
    }

    // UC1: Print Board
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
        int slot = scanner.nextInt();

        return slot;
    }

    // UC4: Convert slot → row & column
    static int[] convertSlotToPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }
}