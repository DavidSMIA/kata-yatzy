package v3.scoring;

import v3.model.Roll;

import java.util.Arrays;
import java.util.List;

public class LargeStraight implements ScoringStrategy {

    private static List<Integer> largeStraight = Arrays.asList(2, 3, 4, 5, 6);

    @Override
    public int score(Roll dicesThrow) {
        return dicesThrow.hasStraight(largeStraight) ? 20 : 0;
    }
}
