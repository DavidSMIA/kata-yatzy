package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import static org.junit.Assert.assertEquals;

public class FullHouseScoringTest {
    private FullHouse fullHouse = new FullHouse();

    @Test
    public void should_score() {
        assertEquals(18, fullHouse.score(new Roll(6,2,2,2,6)));
        assertEquals(7, fullHouse.score(new Roll(1,2,1,2,1)));
    }

    @Test
    public void should_not_score() {
        assertEquals(0, fullHouse.score(new Roll(2,3,4,5,6)));
        assertEquals(0, fullHouse.score(new Roll(2,2,4,4,6)));
    }

}
