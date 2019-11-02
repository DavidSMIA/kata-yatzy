package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class SixesScoringTest {

    private ScoreByDiceValue sixes = new ScoreByDiceValue(6);

    @Test
    public void should_score() {
        assertEquals(30, sixes.score(new Roll(6,6,6,6,6)));
        assertEquals(24, sixes.score(new Roll(6,6,1,6,6)));
        assertEquals(18, sixes.score(new Roll(1,6,1,6,6)));
        assertEquals(12, sixes.score(new Roll(4,1,6,6,4)));
        assertEquals(6, sixes.score(new Roll(3,2,6,2,4)));
    }
    @Test
    public void should_not_score() {
        assertEquals(0, sixes.score(new Roll(1,1,4,2,5)));
        assertEquals(0, sixes.score(new Roll(2,2,2,2,2)));
    }
}
