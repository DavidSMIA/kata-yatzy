package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class ThreeOfKindcoringTest {
    private ThreeOfKind threeOfKind = new ThreeOfKind();

    @Test
    public void should_score() {
        assertEquals(9, threeOfKind.score(new Roll(3,3,3,4,5)));
        assertEquals(15, threeOfKind.score(new Roll(5,3,5,4,5)));
        assertEquals(9, threeOfKind.score(new Roll(3,3,3,3,5)));
    }

    @Test
    public void should_not_score() {
        assertEquals(0, threeOfKind.score(new Roll(1,2,5,4,5)));
        assertEquals(0, threeOfKind.score(new Roll(2,3,3,5,6)));
    }

}
