package v3.scoring;

import v3.model.Roll;

import java.util.Arrays;
import java.util.List;

public class SmallStraight implements ScoringStrategy {

    private static List<Integer> smallStraight = Arrays.asList(1, 2, 3, 4, 5);

    @Override
    public int score(Roll dicesThrow) {
        return dicesThrow.hasStraight(smallStraight) ? 15 : 0;
    }
}
