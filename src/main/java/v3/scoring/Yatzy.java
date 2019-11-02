package v3.scoring;

import v3.model.Roll;

public class Yatzy implements ScoringStrategy {
    @Override
    public int score(Roll dicesRoll) {
        boolean isAllDicesNumberAreEquals = dicesRoll.getDices().stream().distinct().count() <= 1;
        return isAllDicesNumberAreEquals ? 50 : 0;
    }
}
