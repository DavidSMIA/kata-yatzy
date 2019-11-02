package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class FourOfKindScoringTest {
    private FourOfKind fourOfKind = new FourOfKind();

    @Test
    public void should_score() {
        assertEquals(12, fourOfKind.score(new Roll(3,3,3,3,5)));
        assertEquals(20, fourOfKind.score(new Roll(5,5,5,4,5)));
        assertEquals(12, fourOfKind.score(new Roll(3,3,3,3,3)));
    }

    @Test
    public void should_not_score() {
        assertEquals(0, fourOfKind.score(new Roll(1,2,5,4,5)));
        assertEquals(0, fourOfKind.score(new Roll(2,3,3,3,6)));
    }

}
