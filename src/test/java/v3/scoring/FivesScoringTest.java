package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class FivesScoringTest {

    private ScoreByDiceValue fives = new ScoreByDiceValue(5);

    @Test
    public void should_score() {
        assertEquals(25, fives.score(new Roll(5,5,5,5,5)));
        assertEquals(20, fives.score(new Roll(5,5,1,5,5)));
        assertEquals(15, fives.score(new Roll(1,5,1,5,5)));
        assertEquals(10, fives.score(new Roll(4,1,5,5,4)));
        assertEquals(5, fives.score(new Roll(3,2,5,2,4)));
    }
    @Test
    public void should_not_score() {
        assertEquals(0, fives.score(new Roll(1,1,4,2,6)));
        assertEquals(0, fives.score(new Roll(2,2,2,2,2)));
    }
}
