package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class PairScoringTest {
    private Pair pair = new Pair();

    @Test
    public void should_score() {
        assertEquals(6, pair.score(new Roll(3,4,3,5,6)));
        assertEquals(10, pair.score(new Roll(5,3,3,3,5)));
        assertEquals(12, pair.score(new Roll(5,3,6,6,5)));
        assertEquals(12, pair.score(new Roll(6,6,6,6,6)));
    }

    @Test
    public void should_not_score() {
        assertEquals(0, pair.score(new Roll(1,2,3,4,5)));
        assertEquals(0, pair.score(new Roll(2,3,4,5,6)));
    }

}
