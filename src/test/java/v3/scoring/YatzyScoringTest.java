package v3.scoring;

import org.junit.Test;
import v3.model.Roll;
import v3.scoring.Yatzy;

import static org.junit.Assert.assertEquals;

public class YatzyScoringTest {

    private Yatzy yatzy = new Yatzy();

    @Test
    public void should_score() {
        assertEquals(50, yatzy.score(new Roll(4,4,4,4,4)));
        assertEquals(50, yatzy.score(new Roll(1,1,1,1,1)));
    }

    @Test
    public void should_not_score() {
        assertEquals(0, yatzy.score(new Roll(2,4,4,4,4)));
        assertEquals(0, yatzy.score(new Roll(1,1,1,6,1)));
    }

}
