package resources.models.board;

public interface GameBoard {

    char[][] getGameBoard();
    void printBoard();

    void placePositionsOnTheBoard(int position, String player);


}
