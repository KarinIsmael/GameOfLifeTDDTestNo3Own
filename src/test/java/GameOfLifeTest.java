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
}
