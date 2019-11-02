package v3.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Roll {
    private List<Integer> dices;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        this.dices = Arrays.asList(d1, d2, d3, d4, d5);
        if(!validate()) {
            throw new IllegalArgumentException("Some dices have illegal value");
        }
    }

    private boolean validate() {
        return dices.stream().allMatch( d -> d >= 1 && d <= 6);
    }

    public List<Integer> getDices() {
        return dices;
    }

    public boolean hasStraight(List<Integer> straigth) {
        dices.sort(Integer::compareTo);
        return straigth.equals(dices);
    }

    public List<Integer> getPairs() {
        return keepDiceWithEnoughSibling(2)
                .collect(Collectors.toList());
    }

    private Map<Integer, Long> getDicesGroupByValue() {
        return dices.stream().collect(groupingBy(Function.identity(), counting()));
    }

    public long countByDiceValue(int diceValue) {
        return dices.stream().filter(d -> d == diceValue).count();
    }


    public Stream<Integer> keepDiceWithEnoughSibling(int minSibling) {
        return getDicesGroupByValue()
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= minSibling)
                .map(Map.Entry::getKey);
    }

}
