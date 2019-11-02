package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class FoursScoringTest {

    private ScoreByDiceValue fours = new ScoreByDiceValue(4);

    @Test
    public void should_score() {
        assertEquals(20, fours.score(new Roll(4,4,4,4,4)));
        assertEquals(16, fours.score(new Roll(4,4,1,4,4)));
        assertEquals(12, fours.score(new Roll(1,4,1,4,4)));
        assertEquals(8, fours.score(new Roll(4,1,5,5,4)));
        assertEquals(4, fours.score(new Roll(3,2,2,2,4)));
    }
    @Test
    public void should_not_score() {
        assertEquals(0, fours.score(new Roll(1,1,5,2,5)));
        assertEquals(0, fours.score(new Roll(2,2,2,2,2)));
    }
}
