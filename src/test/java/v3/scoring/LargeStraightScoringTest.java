package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class LargeStraightScoringTest {
    private LargeStraight largeStraight = new LargeStraight();

    @Test
    public void should_score() {
        assertEquals(20, largeStraight.score(new Roll(2,3,4,5,6)));
        assertEquals(20, largeStraight.score(new Roll(6,2,3,4,5)));
    }

    @Test
    public void should_not_score() {
        assertEquals(0, largeStraight.score(new Roll(1,2,3,4,5)));
        assertEquals(0, largeStraight.score(new Roll(2,3,5,5,6)));
    }

}
