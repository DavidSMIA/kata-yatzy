package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class TwosScoringTest {

    private ScoreByDiceValue twos = new ScoreByDiceValue(2);

    @Test
    public void should_score() {
        assertEquals(10, twos.score(new Roll(2,2,2,2,2)));
        assertEquals(8, twos.score(new Roll(2,2,1,2,2)));
        assertEquals(6, twos.score(new Roll(1,2,1,2,2)));
        assertEquals(4, twos.score(new Roll(2,1,3,3,2)));
        assertEquals(2, twos.score(new Roll(2,4,4,4,4)));
    }
    @Test
    public void should_not_score() {
        assertEquals(0, twos.score(new Roll(1,1,5,4,5)));
        assertEquals(0, twos.score(new Roll(3,3,3,3,3)));
    }
}
