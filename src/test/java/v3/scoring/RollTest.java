package v3.scoring;

import org.junit.Test;
import v3.model.Roll;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RollTest {

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_illegalArgument_with_value_less_than_one() {
        new Roll(0,3,4,5,1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_illegalArgument_with_value_more_than_six() {
        new Roll(3,4,7,5,1);
    }

    @Test
    public void should_return_no_pair() {
        assertEquals(Collections.emptyList(), new Roll(1,2,4,5,3).getPairs());
        assertEquals(Collections.emptyList(), new Roll(2,6,1,5,4).getPairs());
    }

    @Test
    public void should_return_one_pair() {
        assertEquals(Collections.singletonList(2), new Roll(2,2,1,5,3).getPairs());
        assertEquals(Collections.singletonList(2), new Roll(2,2,1,5,2).getPairs());
        assertEquals(Collections.singletonList(3), new Roll(3,3,3,3,3).getPairs());
    }

    @Test
    public void should_return_two_pair() {
        assertEquals(Arrays.asList(2,3), new Roll(2,2,1,3,3).getPairs());
        assertEquals(Arrays.asList(2,3), new Roll(2,2,3,3,3).getPairs());
    }

    @Test
    public void should_return_straight() {
        assertTrue(new Roll(3,4,5,1,2).hasStraight(Arrays.asList(1,2,3,4,5)));
        assertTrue(new Roll(4,3,5,2,6).hasStraight(Arrays.asList(2,3,4,5,6)));
    }

    @Test
    public void should_not_return_straight() {
        assertFalse(new Roll(1,2,5,4,5).hasStraight(Arrays.asList(1,2,3,4,5)));
        assertFalse(new Roll(2,3,4,5,4).hasStraight(Arrays.asList(2,3,4,5,6)));
        assertFalse(new Roll(3,4,5,1,2).hasStraight(Arrays.asList(2,3,4,5,6)));
    }

    @Test
    public void should_count_dice_by_value() {
        assertEquals(2, new Roll(2, 1, 1, 3, 3).countByDiceValue(1));
        assertEquals(5, new Roll(2,2,2,2,2).countByDiceValue(2));
        assertEquals(0, new Roll(2,2,2,2,2).countByDiceValue(3));
    }


}
