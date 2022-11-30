import resources.common.Game_Messages;
import resources.models.board.GameBoard;
import resources.models.board.TicTacToeBoard;
import resources.models.players.CPU;
import resources.models.players.Player;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameBoard board = new TicTacToeBoard();
        Player player = new Player();
        CPU CPU = new CPU();

        System.out.println(Game_Messages.WELCOME_MESSAGE);

        board.printBoard();

        while (true) {
            System.out.print(Game_Messages.ENTER_POSITION_MESSAGE);

            int playerPosition = scanner.nextInt();
            while (player.contains(playerPosition) || CPU.contains(playerPosition)) {
                System.out.print(Game_Messages.TAKEN_POSITION_MESSAGE);
                playerPosition = scanner.nextInt();
            }
            board.placePositionsOnTheBoard(playerPosition, "player");
            player.addPosition(playerPosition);

            String result = checkWinner(player.getPositions(), CPU.getPositions());
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int CPUPosition = random.nextInt(9) + 1;
            while (player.contains(CPUPosition) || CPU.contains(CPUPosition)) {
                CPUPosition = random.nextInt(9) + 1;
            }
            board.placePositionsOnTheBoard(CPUPosition, "CPU");
            CPU.addPosition(CPUPosition);

            board.printBoard();

            result = checkWinner(player.getPositions(), CPU.getPositions());
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            System.out.println(result);
        }


    }
    private static String checkWinner(Collection<Integer> playerPositions, Collection<Integer> CPUPositions) {

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
