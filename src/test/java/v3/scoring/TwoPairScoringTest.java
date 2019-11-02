package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class TwoPairScoringTest {
    private TwoPair twoPair = new TwoPair();

    @Test
    public void should_score() {
        assertEquals(16, twoPair.score(new Roll(3,3,5,4,5)));
        assertEquals(16, twoPair.score(new Roll(3,3,5,4,5)));
        assertEquals(14, twoPair.score(new Roll(6,6,1,1,6)));
    }

    @Test
    public void should_not_score() {
        assertEquals(0, twoPair.score(new Roll(1,2,5,4,5)));
        assertEquals(0, twoPair.score(new Roll(2,3,3,5,6)));
        assertEquals(0, twoPair.score(new Roll(6,6,6,6,6)));
    }

}
