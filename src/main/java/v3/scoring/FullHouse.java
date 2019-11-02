package v3.scoring;

import v3.model.Roll;
import java.util.Optional;

public class FullHouse implements ScoringStrategy {
    @Override
    public int score(Roll dicesThrow) {
        Optional<Integer> threeOfaKind  = dicesThrow.keepDiceWithEnoughSibling(3).findAny();
        if(threeOfaKind.isPresent()) {
            Optional<Integer> otherPair = dicesThrow.keepDiceWithEnoughSibling(2).filter(e -> !threeOfaKind.get().equals(e)).findAny();
            return otherPair.map( pair -> threeOfaKind.get() * 3 + pair * 2).orElse(0);
        }
        return 0;
    }
}
