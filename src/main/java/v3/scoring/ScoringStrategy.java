package v3.scoring;

import v3.model.Roll;

public interface ScoringStrategy {

    int score(Roll dicesRoll);
}
