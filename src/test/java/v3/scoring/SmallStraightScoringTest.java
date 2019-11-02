package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class SmallStraightScoringTest {
    private SmallStraight smallStraight = new SmallStraight();

    @Test
    public void should_score() {
        assertEquals(15, smallStraight.score(new Roll(1,2,3,4,5)));
        assertEquals(15, smallStraight.score(new Roll(2,3,4,5,1)));

    }

    @Test
    public void should_not_score() {
        assertEquals(0, smallStraight.score(new Roll(1,2,2,4,5)));
        assertEquals(0, smallStraight.score(new Roll(2,3,4,5,6)));
    }

}
