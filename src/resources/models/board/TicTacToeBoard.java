package resources.models.board;

public class TicTacToeBoard implements GameBoard {

    private final char[][] gameBoard;

    public TicTacToeBoard() {
        gameBoard = new char[][]{
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    @Override
    public void printBoard() {
        for (char[] row : gameBoard) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    @Override
    public void placePositionsOnTheBoard(int position, String player) {
        char symbol = ' ';

        if ("CPU".equals(player)) {
            symbol = 'O';
        } else if ("player".equals(player)) {
            symbol = 'X';
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
}
