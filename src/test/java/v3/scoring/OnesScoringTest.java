package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class OnesScoringTest {

    private ScoreByDiceValue ones = new ScoreByDiceValue(1);

    @Test
    public void should_score() {
        assertEquals(5, ones.score(new Roll(1,1,1,1,1)));
        assertEquals(4, ones.score(new Roll(1,1,1,1,2)));
        assertEquals(3, ones.score(new Roll(1,1,1,2,2)));
        assertEquals(2, ones.score(new Roll(1,1,3,3,3)));
        assertEquals(1, ones.score(new Roll(1,4,4,4,4)));
    }
    @Test
    public void should_not_score() {
        assertEquals(0, ones.score(new Roll(2,2,5,4,5)));
        assertEquals(0, ones.score(new Roll(3,3,3,3,3)));
    }
}
