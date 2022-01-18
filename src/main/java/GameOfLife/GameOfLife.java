package GameOfLife;

public class GameOfLife {
    int[][] grid;
    int numberOfRow;
    int numberOfColumn;

    public GameOfLife(int numberOfRow, int numberOfColumn) {
        grid = new int[numberOfRow][numberOfColumn];
        this.numberOfRow = grid.length;
        this.numberOfColumn = grid[0].length;
    }

    public void setLivingCellToGrid(int row, int column) {
        grid[row][column] = 1;
    }

    public int numberOfAliveNeighbours(int row, int column) {


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

        int aliveNeighbour = 0;

        for (int i = 0; i < neighbourCounter.length; i++) {

            int checkRow = neighbourCounter[i][0];
            int checkColumn = neighbourCounter[i][1];

            if (isInTheGameBoard(checkRow, checkColumn)) {
                aliveNeighbour += grid[checkRow][checkColumn];
            }
        }
        return aliveNeighbour;
    }

    private boolean isInTheGameBoard(int row, int column) {
        return row >= 0 && column >= 0 && row < numberOfRow && column < numberOfColumn;
    }


    public void evaluateNextGeneration() {

        int[][] nextGeneration = new int[numberOfRow][numberOfColumn];

        for (int row = 0; row < numberOfRow; row++) {
            for (int column = 0; column < numberOfColumn; column++) {
               if (aLiveCellHasLessThanTwoNeighbors(row, column)) {
                   nextGeneration[row][column] = 0;
               } else if (aLiveCellHasMoreThanThreeNeighbors(row, column)) {
                   nextGeneration[row][column] = 0;
               }else if (livingCell(row,column) && numberOfAliveNeighbours(row, column) ==2) {
                   nextGeneration[row][column]=1;
               } else if (livingCell(row,column) && numberOfAliveNeighbours(row, column) ==3) {
                   nextGeneration[row][column]=1;
               } else if (deadCell(row,column) && numberOfAliveNeighbours(row, column) ==3)
                   nextGeneration[row][column]=1;
            }
        }

        grid = nextGeneration.clone();
    }

    private boolean aLiveCellHasMoreThanThreeNeighbors(int row, int column) {
        return livingCell(row, column) && numberOfAliveNeighbours(row, column) > 3;
    }

    public boolean livingCell(int row, int column) {
        return grid[row][column] == 1;
    }

    public boolean deadCell(int row, int column) {
        return grid[row][column] == 0;
    }

    private boolean aLiveCellHasLessThanTwoNeighbors(int row, int column) {
        int checkNeighbors = numberOfAliveNeighbours(row, column);
        return livingCell(row, column) && checkNeighbors < 2;
    }

}
