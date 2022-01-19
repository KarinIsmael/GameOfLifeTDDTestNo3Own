package GameOfLife;

public class GameOfLife {
    int[][] grid;
    int numberOfRows;
    int numberOfColumns;

    public GameOfLife(int numberOfRows, int numberOfColumns) {
        grid = new int[numberOfRows][numberOfColumns];
        this.numberOfRows = grid.length;
        this.numberOfColumns = grid[0].length;
    }

    public void setLivingCell(int row, int column) {
        grid[row][column] = 1;
    }

    public int calculateLivingNeighbors(int row, int column) {


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

        return checkLivingNeighbors(neighbourCounter);
    }

    private int checkLivingNeighbors(int[][] neighbourCounter) {

        int livingNeighbors = 0;

        for (int i = 0; i < neighbourCounter.length; i++) {

            int checkRow = neighbourCounter[i][0];
            int checkColumn = neighbourCounter[i][1];

            if (isInTheGameBoard(checkRow, checkColumn)) {
                livingNeighbors += grid[checkRow][checkColumn];
            }
        }

        return livingNeighbors;
    }

    private boolean isInTheGameBoard(int row, int column) {
        return row >= 0 && column >= 0 && row < numberOfRows && column < numberOfColumns;
    }


    public void calculateNextGeneration() {

        int[][] nextGeneration = new int[numberOfRows][numberOfColumns];

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
               if (aLiveCellHasLessThanTwoNeighbors(row, column)) {
                   nextGeneration[row][column] = 0;
               } else if (aLiveCellHasMoreThanThreeNeighbors(row, column)) {
                   nextGeneration[row][column] = 0;
               }else if (aLiveCellHasExactlyTwoNeighbors(row, column)) {
                   nextGeneration[row][column]=1;
               } else if (aLiveCellHasExactlyThreeNeighbors(row, column)) {
                   nextGeneration[row][column]=1;
               } else if (aDeadCellHasExactlyThreeNeighbors(row, column))
                   nextGeneration[row][column]=1;
            }
        }

        grid = nextGeneration.clone();
    }

    private boolean aDeadCellHasExactlyThreeNeighbors(int row, int column) {
        return deadCell(row, column) && calculateLivingNeighbors(row, column) == 3;
    }

    private boolean aLiveCellHasExactlyThreeNeighbors(int row, int column) {
        return livingCell(row, column) && calculateLivingNeighbors(row, column) == 3;
    }

    private boolean aLiveCellHasExactlyTwoNeighbors(int row, int column) {
        return livingCell(row, column) && calculateLivingNeighbors(row, column) == 2;
    }

    private boolean aLiveCellHasMoreThanThreeNeighbors(int row, int column) {
        return livingCell(row, column) && calculateLivingNeighbors(row, column) > 3;
    }

    public boolean livingCell(int row, int column) {
        return grid[row][column] == 1;
    }

    public boolean deadCell(int row, int column) {
        return grid[row][column] == 0;
    }

    private boolean aLiveCellHasLessThanTwoNeighbors(int row, int column) {
        int checkNeighbors = calculateLivingNeighbors(row, column);
        return livingCell(row, column) && checkNeighbors < 2;
    }

}
