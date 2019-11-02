package v3.scoring;

import v3.model.Roll;

public class FourOfKind implements ScoringStrategy {
    @Override
    public int score(Roll dicesThrow) {
       return dicesThrow.keepDiceWithEnoughSibling(4)
               .map(d -> d * 4)
               .findFirst()
               .orElse(0);
    }
}
