package v3.scoring;

import v3.model.Roll;

public class Chance implements ScoringStrategy {
    @Override
    public int score(Roll dicesRoll) {
        return dicesRoll.getDices().stream().reduce(0, Integer::sum);
    }
}
