package v3.scoring;

import v3.model.Roll;

import java.util.Optional;

public class Pair implements ScoringStrategy {
    @Override
    public int score(Roll dicesRoll) {
        Optional<Integer> maxPair = dicesRoll.getPairs().stream().max(Integer::compareTo);
        return maxPair.map(e -> e * 2).orElse(0);
    }
}
