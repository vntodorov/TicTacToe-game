package TicTacToe;

import java.util.*;

public class TicTacToe {

    static List<Integer> playerPositions = new ArrayList<>();
    static List<Integer> CPUPositions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe - The Game! Here's the board:");

        char[][] gameBoard =
                {
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                };
        printTicTacToeBoard(gameBoard);

        while (true) {
            System.out.print("Enter your position (1-9): ");

            int playerPosition = scanner.nextInt();
            while (playerPositions.contains(playerPosition) || CPUPositions.contains(playerPosition)) {
                System.out.print("This position has been taken! Enter a free position (1-9): ");
                playerPosition = scanner.nextInt();
            }
            placePosition(gameBoard, playerPosition, "player");

            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int CPUPosition = random.nextInt(9) + 1;
            while (playerPositions.contains(CPUPosition) || CPUPositions.contains(CPUPosition)) {
                CPUPosition = random.nextInt(9) + 1;
            }
            placePosition(gameBoard, CPUPosition, "CPU");

            printTicTacToeBoard(gameBoard);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            System.out.println(result);
        }


    }

    private static void printTicTacToeBoard(char[][] gameBoard) {

        for (char[] row : gameBoard) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();

        }
    }

    private static void placePosition(char[][] gameBoard, int position, String player) {
        char symbol = ' ';

        if ("CPU".equals(player)) {
            symbol = 'O';
            CPUPositions.add(position);
        } else if ("player".equals(player)) {
            symbol = 'X';
            playerPositions.add(position);
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }

    private static String checkWinner() {

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> middleCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> rightCross = Arrays.asList(1, 5, 9);
        List<Integer> leftCross = Arrays.asList(3, 5, 7);

        List<List<Integer>> allWinningCombinations = new ArrayList<>();
        allWinningCombinations.add(topRow);
        allWinningCombinations.add(middleRow);
        allWinningCombinations.add(bottomRow);
        allWinningCombinations.add(leftCol);
        allWinningCombinations.add(middleCol);
        allWinningCombinations.add(rightCol);
        allWinningCombinations.add(rightCross);
        allWinningCombinations.add(leftCross);

        for (List<Integer> winningCombination : allWinningCombinations) {

            if (playerPositions.containsAll(winningCombination)) {
                return "You won the game!";
            } else if (CPUPositions.containsAll(winningCombination)) {
                return "You lost! Try again!";
            }

        }

        if (playerPositions.size() + CPUPositions.size() == 9) {
            return "DRAW!";
        }

        return "";
    }


}
