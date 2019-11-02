package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class ThreesScoringTest {

    private ScoreByDiceValue threes = new ScoreByDiceValue(3);

    @Test
    public void should_score() {
        assertEquals(15, threes.score(new Roll(3,3,3,3,3)));
        assertEquals(12, threes.score(new Roll(3,3,1,3,3)));
        assertEquals(9, threes.score(new Roll(1,3,1,3,3)));
        assertEquals(6, threes.score(new Roll(3,1,4,5,3)));
        assertEquals(3, threes.score(new Roll(3,4,4,4,4)));
    }
    @Test
    public void should_not_score() {
        assertEquals(0, threes.score(new Roll(1,1,5,4,5)));
        assertEquals(0, threes.score(new Roll(2,2,2,2,2)));
    }
}
