package v3.scoring;

import v3.model.Roll;

public class ScoreByDiceValue implements ScoringStrategy {

    private int diceValue;

    public ScoreByDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    @Override
    public int score(Roll dicesRoll) {
       return Math.toIntExact(dicesRoll.countByDiceValue(diceValue) * diceValue);
    }
}
