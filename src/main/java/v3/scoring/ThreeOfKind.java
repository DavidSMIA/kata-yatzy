package v3.scoring;

import v3.model.Roll;

public class ThreeOfKind implements ScoringStrategy {
    @Override
    public int score(Roll dicesThrow) {
       return dicesThrow.keepDiceWithEnoughSibling(3)
               .map(d -> d * 3)
               .findFirst()
               .orElse(0);
    }
}
