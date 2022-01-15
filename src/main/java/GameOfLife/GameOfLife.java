package GameOfLife;

public class GameOfLife {
    int[][] grid;
    int rowNumber;
    int columnNumber;

    public GameOfLife(int RowNo, int ColumnNo){
        grid = new int[RowNo][ColumnNo];
        this.rowNumber = grid.length;
        this.columnNumber = grid[0].length;
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

            if (row >= 0 && column >= 0 && row < rowNumber && column < columnNumber) {
                aliveNeighbour += grid[ints[0]][ints[1]];
            }
        }
        return aliveNeighbour;
    }
}
