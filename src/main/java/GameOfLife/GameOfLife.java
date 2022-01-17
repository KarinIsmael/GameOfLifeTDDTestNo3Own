package GameOfLife;

public class GameOfLife {
    int[][] grid;
    int numberOfRow;
    int numberOfColumn;

    public GameOfLife(int numberOfRow, int numberOfColumn){
        grid = new int[numberOfRow][numberOfColumn];
        this.numberOfRow = grid.length;
        this.numberOfColumn = grid[0].length;
    }

    public int numberOfAliveNeighbours(int row, int column) {

        int aliveNeighbour = 0;

        int[][] neighbourCounter = {
                {row - 1, column - 1},
                {row - 1, column},
                {row - 1, column + 1},
                {row, column + 1},
                {row + 1, column + 1},
                {row + 1, column},
                {row + 1, column - 1},
                {row, column - 1},
        };

        for (int[] ints : neighbourCounter) {

            int checkRow = ints[0];
            int checkColumn = ints[1];

            if (isInTheGameBoard(row, column)) {
                aliveNeighbour += grid[checkRow][checkColumn];
            }
        }
        return aliveNeighbour;
    }

    private boolean isInTheGameBoard(int row, int column) {
        return row >= 0 && column >= 0 && row < numberOfRow && column < numberOfColumn;
    }


    public void cellIsAlive(int row, int column) {
        grid[row][column] = 1;
    }
}
