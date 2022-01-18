import GameOfLife.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

 class GameOfLifeTest {

    private final GameOfLife gameOfLife;

     GameOfLifeTest() {
        gameOfLife = new GameOfLife(4, 8);
    }

    @Test
     void oneAloneCellHasNoNeighbours() {

        int numberOfNeighbours = gameOfLife.numberOfAliveNeighbours(1, 2);

        assertThat(numberOfNeighbours).isZero();

    }

    @Test
     void checkThatGameFindsOneNeighbor() {

        gameOfLife.setLivingCellToGrid(1, 3);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(1);
    }

    @Test
     void checkThatGameFindsTwoNeighbors() {

        gameOfLife.setLivingCellToGrid(1, 3);
        gameOfLife.setLivingCellToGrid(2, 3);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(2);
    }

    @Test
     void checkThatGameFindsThreeNeighbors() {

        gameOfLife.setLivingCellToGrid(1, 3);
        gameOfLife.setLivingCellToGrid(2, 3);
        gameOfLife.setLivingCellToGrid(1, 1);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(3);
    }

    @Test
     void checkThatGameFindsFourNeighbors() {

        gameOfLife.setLivingCellToGrid(1, 3);
        gameOfLife.setLivingCellToGrid(2, 3);
        gameOfLife.setLivingCellToGrid(1, 1);
        gameOfLife.setLivingCellToGrid(2, 1);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(4);
    }

    @Test
     void checkThatGameFindsFiveNeighbors() {

        gameOfLife.setLivingCellToGrid(1, 3);
        gameOfLife.setLivingCellToGrid(2, 3);
        gameOfLife.setLivingCellToGrid(1, 1);
        gameOfLife.setLivingCellToGrid(2, 1);
        gameOfLife.setLivingCellToGrid(1, 2);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(5);
    }

    @Test
     void checkThatGameFindsSixNeighbors() {

        gameOfLife.setLivingCellToGrid(1, 3);
        gameOfLife.setLivingCellToGrid(2, 3);
        gameOfLife.setLivingCellToGrid(1, 1);
        gameOfLife.setLivingCellToGrid(2, 1);
        gameOfLife.setLivingCellToGrid(1, 2);
        gameOfLife.setLivingCellToGrid(3, 3);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(6);
    }

    @Test
     void checkThatGameFindsSevenNeighbors() {

        gameOfLife.setLivingCellToGrid(1, 3);
        gameOfLife.setLivingCellToGrid(2, 3);
        gameOfLife.setLivingCellToGrid(1, 1);
        gameOfLife.setLivingCellToGrid(2, 1);
        gameOfLife.setLivingCellToGrid(1, 2);
        gameOfLife.setLivingCellToGrid(3, 3);
        gameOfLife.setLivingCellToGrid(3, 2);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(7);
    }

    @Test
     void checkThatGameFindsEightNeighbors() {

        gameOfLife.setLivingCellToGrid(1, 3);
        gameOfLife.setLivingCellToGrid(2, 3);
        gameOfLife.setLivingCellToGrid(1, 1);
        gameOfLife.setLivingCellToGrid(2, 1);
        gameOfLife.setLivingCellToGrid(1, 2);
        gameOfLife.setLivingCellToGrid(3, 3);
        gameOfLife.setLivingCellToGrid(3, 2);
        gameOfLife.setLivingCellToGrid(3, 1);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(8);
    }

    @Test
    void cellLessThanTwoNeighborsDies(){
        gameOfLife.setLivingCellToGrid(0,0);
        gameOfLife.setLivingCellToGrid(0,1);

        gameOfLife.evaluateNextGeneration();

        assertThat(gameOfLife.livingCell(0,0)).isFalse();
    }

    @Test
    void cellThatHasMoreThanThreeNeighborsDies(){
       gameOfLife.setLivingCellToGrid(1, 3);
       gameOfLife.setLivingCellToGrid(2, 3);
       gameOfLife.setLivingCellToGrid(1, 1);
       gameOfLife.setLivingCellToGrid(2, 1);

       gameOfLife.evaluateNextGeneration();

       assertThat(gameOfLife.livingCell(1,3)).isFalse();
    }

    @Test
    void anyLiveCellWithTwoLiveNeighborsLivesOnToTheNextGeneration(){
       gameOfLife.setLivingCellToGrid(0, 0);
       gameOfLife.setLivingCellToGrid(0, 1);
       gameOfLife.setLivingCellToGrid(1, 1);

       gameOfLife.evaluateNextGeneration();

       assertThat(gameOfLife.livingCell(1,1)).isTrue();
    }

    @Test
    void anyLiveCellWithThreeLiveNeighborsLivesOnToTheNextGeneration(){
       gameOfLife.setLivingCellToGrid(0, 0);
       gameOfLife.setLivingCellToGrid(0, 1);
       gameOfLife.setLivingCellToGrid(1, 1);
       gameOfLife.setLivingCellToGrid(1, 0);

       gameOfLife.evaluateNextGeneration();

       assertThat(gameOfLife.livingCell(1,1)).isTrue();
    }

    @Test
    void anyDeadCellWithExactlyThreeLiveNeighborsBecomesALiveCell(){
       gameOfLife.setLivingCellToGrid(0, 0);
       gameOfLife.setLivingCellToGrid(0, 1);
       gameOfLife.setLivingCellToGrid(1, 1);

       gameOfLife.evaluateNextGeneration();

       assertThat(gameOfLife.livingCell(1,0)).isTrue();
    }


}
