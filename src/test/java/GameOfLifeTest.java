import GameOfLife.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameOfLifeTest {

    private final GameOfLife gameOfLife;

    public GameOfLifeTest(){
        gameOfLife = new GameOfLife(4,8);
    }


@Test
public void OneAloneCellHasNoNeighbours(){

    int numberOfNeighbours = gameOfLife.numberOfAliveNeighbours(1, 2);

    assertThat(numberOfNeighbours).isEqualTo(0);

}
    @Test
    public void CheckThatGameFindsOneNeighbor() {

        gameOfLife.cellIsAlive(1, 3);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(1);
    }

    @Test
    public void CheckThatGameFindsTwoNeighbors() {

        gameOfLife.cellIsAlive(1, 3);
        gameOfLife.cellIsAlive(2, 3);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(2);
    }

    @Test
    public void CheckThatGameFindsThreeNeighbors() {

        gameOfLife.cellIsAlive(1, 3);
        gameOfLife.cellIsAlive(2, 3);
        gameOfLife.cellIsAlive(1,1);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(3);
    }

    @Test
    public void CheckThatGameFindsFourNeighbors() {

        gameOfLife.cellIsAlive(1, 3);
        gameOfLife.cellIsAlive(2, 3);
        gameOfLife.cellIsAlive(1,1);
        gameOfLife.cellIsAlive(2,1);

        int neighboursCount = gameOfLife.numberOfAliveNeighbours(2, 2);

        assertThat(neighboursCount).isEqualTo(4);
    }

}
