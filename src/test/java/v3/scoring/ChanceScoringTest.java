package v3.scoring;

import org.junit.Test;
import v3.model.Roll;
import v3.scoring.Chance;

import static org.junit.Assert.assertEquals;

public class ChanceScoringTest {

    private Chance chance = new Chance();

    @Test
    public void should_score() {
        assertEquals(15, chance.score(new Roll(2,3,4,5,1)));
        assertEquals(16, chance.score(new Roll(3,3,4,5,1)));
    }


}
