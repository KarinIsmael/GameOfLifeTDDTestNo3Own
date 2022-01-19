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

        int numberOfNeighbours = gameOfLife.calculateLivingNeighbors(1, 2);

        assertThat(numberOfNeighbours).isZero();

    }

    @Test
     void checkThatGameFindsOneNeighbor() {

        gameOfLife.setLivingCell(1, 3);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(1);
    }

    @Test
     void checkThatGameFindsTwoNeighbors() {

        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 3);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(2);
    }

    @Test
     void checkThatGameFindsThreeNeighbors() {

        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 1);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(3);
    }

    @Test
     void checkThatGameFindsFourNeighbors() {

        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(2, 1);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(4);
    }

    @Test
     void checkThatGameFindsFiveNeighbors() {

        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(2, 1);
        gameOfLife.setLivingCell(1, 2);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(5);
    }

    @Test
     void checkThatGameFindsSixNeighbors() {

        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(2, 1);
        gameOfLife.setLivingCell(1, 2);
        gameOfLife.setLivingCell(3, 3);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(6);
    }

    @Test
     void checkThatGameFindsSevenNeighbors() {

        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(2, 1);
        gameOfLife.setLivingCell(1, 2);
        gameOfLife.setLivingCell(3, 3);
        gameOfLife.setLivingCell(3, 2);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(7);
    }

    @Test
     void checkThatGameFindsEightNeighbors() {

        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(2, 1);
        gameOfLife.setLivingCell(1, 2);
        gameOfLife.setLivingCell(3, 3);
        gameOfLife.setLivingCell(3, 2);
        gameOfLife.setLivingCell(3, 1);

        int neighboursCount = gameOfLife.calculateLivingNeighbors(2, 2);

        assertThat(neighboursCount).isEqualTo(8);
    }

    @Test
    void cellLessThanTwoNeighborsDies(){
        gameOfLife.setLivingCell(0,0);
        gameOfLife.setLivingCell(0,1);

        gameOfLife.calculateNextGeneration();

        assertThat(gameOfLife.livingCell(0,0)).isFalse();
    }

    @Test
    void cellThatHasMoreThanThreeNeighborsDies(){
       gameOfLife.setLivingCell(1, 3);
       gameOfLife.setLivingCell(2, 3);
       gameOfLife.setLivingCell(1, 1);
       gameOfLife.setLivingCell(2, 1);

       gameOfLife.calculateNextGeneration();

       assertThat(gameOfLife.livingCell(1,3)).isFalse();
    }

    @Test
    void anyLiveCellWithTwoLiveNeighborsLivesOnToTheNextGeneration(){
       gameOfLife.setLivingCell(0, 0);
       gameOfLife.setLivingCell(0, 1);
       gameOfLife.setLivingCell(1, 1);

       gameOfLife.calculateNextGeneration();

       assertThat(gameOfLife.livingCell(1,1)).isTrue();
    }

    @Test
    void anyLiveCellWithThreeLiveNeighborsLivesOnToTheNextGeneration(){
       gameOfLife.setLivingCell(0, 0);
       gameOfLife.setLivingCell(0, 1);
       gameOfLife.setLivingCell(1, 1);
       gameOfLife.setLivingCell(1, 0);

       gameOfLife.calculateNextGeneration();

       assertThat(gameOfLife.livingCell(1,1)).isTrue();
    }

    @Test
    void anyDeadCellWithExactlyThreeLiveNeighborsBecomesALiveCell(){
       gameOfLife.setLivingCell(0, 0);
       gameOfLife.setLivingCell(0, 1);
       gameOfLife.setLivingCell(1, 1);

       gameOfLife.calculateNextGeneration();

       assertThat(gameOfLife.livingCell(1,0)).isTrue();
    }


}
