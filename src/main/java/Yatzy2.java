import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Yatzy2 {

    protected List<Integer> dices;

    public Yatzy2(int d1, int d2, int d3, int d4, int d5) {
        dices = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int chance() {
        return dices.stream().reduce(0, Integer::sum);
    }

    public int yatzy() {
        boolean isAllDicesNumberAreEquals = dices.stream().distinct().count() <= 1;
        return isAllDicesNumberAreEquals ? 50 : 0;
    }

    public int ones() {
        return sumForSpecificNumber(1);
    }

    public int twos() {
        return sumForSpecificNumber(2);
    }

    public int threes() {
        return sumForSpecificNumber(3);
    }

    public int fours() {
        return sumForSpecificNumber(4);
    }

    public int fives() {
        return sumForSpecificNumber(5);
    }

    public int sixes() {
        return sumForSpecificNumber(6);
    }

    public int pair() {
        Map<Integer, Long> dicesGroupByValue = getDicesGroupByValue();
        Optional<Map.Entry<Integer, Long>> highestDicePair = keepDiceWithEnoughSibling(dicesGroupByValue, 2).max(Comparator.comparing(Map.Entry::getKey));
        return highestDicePair.map(e -> e.getKey() * 2).orElse(0);
    }

    public int twoPairs() {
        Map<Integer, Long> dicesGroupByValue = getDicesGroupByValue();
        List<Integer> pairs = keepDiceWithEnoughSibling(dicesGroupByValue, 2).map(Map.Entry::getKey).collect(Collectors.toList());
        if (pairs.size() == 2) {
            return pairs.stream().mapToInt(p -> p * 2).sum();
        }
        return 0;
    }

    public int fourOfAKind() {
        return multipleOfAKind(4);
    }

    public int threeOfAKind() {
        return multipleOfAKind(3);
    }

    public int smallStraight() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        dices.sort(Integer::compareTo);
        return expected.equals(dices) ? 15 : 0;
    }

    public int largeStraight() {
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6);
        dices.sort(Integer::compareTo);
        return expected.equals(dices) ? 20 : 0;
    }

    public int fullHouse() {
        Map<Integer, Long> dicesGroupByValue = getDicesGroupByValue();
        Optional<Integer> threeOfaKind = keepDiceWithEnoughSibling(dicesGroupByValue, 3).map(Map.Entry::getKey).findAny();
        if (threeOfaKind.isPresent()) {
            dicesGroupByValue.remove(threeOfaKind.get());
            Optional<Integer> pair = keepDiceWithEnoughSibling(dicesGroupByValue, 2).map(Map.Entry::getKey).findAny();
            if (pair.isPresent()) {
                return pair.get() * 2 + threeOfaKind.get() * 3;
            }
        }
        return 0;
    }

    private int sumForSpecificNumber(int value) {
        return dices.stream().filter(d -> d == value).reduce(0, Integer::sum);
    }

    private Map<Integer, Long> getDicesGroupByValue() {
        return dices.stream().collect(groupingBy(Function.identity(), counting()));
    }

    private Stream<Map.Entry<Integer, Long>> keepDiceWithEnoughSibling(Map<Integer, Long> dicesGroupByValue, int minSibling) {
        return dicesGroupByValue.entrySet().stream().filter(e -> e.getValue() >= minSibling);
    }

    private int multipleOfAKind(int kindValue) {
        Map<Integer, Long> dicesGroupByValue = getDicesGroupByValue();
        Optional<Integer> fourOfAKind = keepDiceWithEnoughSibling(dicesGroupByValue, kindValue).map(Map.Entry::getKey).findAny();
        return fourOfAKind.map(d -> d * kindValue).orElse(0);
    }
}



