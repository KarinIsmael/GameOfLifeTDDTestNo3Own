import GameOfLife.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameOfLifeTest {

GameOfLife gameOfLife = new GameOfLife(4,8);


@Test
public void OneAloneCellHasNoNeighbours(){
    int numberofNeighbours = gameOfLife.numberOfAliveNeighbours(1, 2);

    assertThat(numberofNeighbours).isEqualTo(0);

}
}
