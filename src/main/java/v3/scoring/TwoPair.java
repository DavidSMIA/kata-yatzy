package v3.scoring;

import v3.model.Roll;
import java.util.List;

public class TwoPair implements ScoringStrategy {
    @Override
    public int score(Roll dicesRoll) {
        List<Integer> pairs = dicesRoll.getPairs();
        if(pairs.size() == 2) {
            return pairs.stream().mapToInt(p -> p * 2).sum();
        }
        return 0;
    }
}
