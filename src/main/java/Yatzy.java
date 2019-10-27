import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        boolean isAllDicesNumberAreEquals = Stream.of(d1, d2, d3, d4, d5).distinct().count() <= 1;
        return isAllDicesNumberAreEquals ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return getSumForSpecificNumber(d1, d2, d3, d4, d5, 1);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return getSumForSpecificNumber(d1, d2, d3, d4, d5, 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return getSumForSpecificNumber(d1, d2, d3, d4, d5, 3);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5)
    {
        return getSumForSpecificNumber(d1, d2, d3, d4, d5, 4);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5)
    {
        return getSumForSpecificNumber(d1, d2, d3, d4, d5, 5);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5)
    {
        return getSumForSpecificNumber(d1, d2, d3, d4, d5, 6);
    }

    public static int scorePair(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> dicesGroupByValue = groupDiceByValue(d1, d2, d3, d4, d5);
        Optional<Map.Entry<Integer, Long>> highestDicePair = keepDiceWithEnoughSibling(dicesGroupByValue, 2).max(Comparator.comparing(Map.Entry::getKey));
        return highestDicePair.map(e -> e.getKey() * 2).orElse(0);
    }


    public static int twoPair(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> dicesGroupByValue = groupDiceByValue(d1, d2, d3, d4, d5);
        List<Integer> pairs = keepDiceWithEnoughSibling(dicesGroupByValue, 2).map(Map.Entry::getKey).collect(Collectors.toList());
        if(pairs.size() == 2) {
            return pairs.stream().mapToInt(p -> p * 2).sum();
        }
        return 0;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        return multipleOfAKind(d1, d2, d3, d4, d5, 4);
    }

    public static int threeOfKind(int d1, int d2, int d3, int d4, int d5)
    {
        return multipleOfAKind(d1, d2, d3, d4, d5, 3);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] expected =  { 1, 2, 3, 4, 5};
        int[] actual = new int[]{d1, d2, d3, d4, d5};
        Arrays.sort(actual);
        return Arrays.equals(expected,actual) ? 15 : 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] expected =  { 2, 3, 4, 5, 6};
        int[] actual = new int[]{d1, d2, d3, d4, d5};
        Arrays.sort(actual);
        return Arrays.equals(expected,actual) ? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> dicesGroupByValue = groupDiceByValue(d1, d2, d3, d4, d5);
        Optional<Integer> threeOfaKind  = keepDiceWithEnoughSibling(dicesGroupByValue, 3).map(Map.Entry::getKey).findAny();
        if(threeOfaKind.isPresent()) {
            dicesGroupByValue.remove(threeOfaKind.get());
            Optional<Integer> pair  = keepDiceWithEnoughSibling(dicesGroupByValue, 2).map(Map.Entry::getKey).findAny();
            if(pair.isPresent()) {
                return pair.get() * 2 + threeOfaKind.get() * 3;
            }
        }
        return 0;
    }

    private static Stream<Map.Entry<Integer, Long>> keepDiceWithEnoughSibling(Map<Integer, Long> dicesGroupByValue, int minSibling) {
        return dicesGroupByValue.entrySet().stream().filter(e -> e.getValue() >= minSibling);
    }

    private static Map<Integer, Long> groupDiceByValue(int d1, int d2, int d3, int d4, int d5) {
        return Stream.of(d1, d2, d3, d4, d5).collect(groupingBy(Function.identity(), counting()));
    }

    private static int getSumForSpecificNumber(int d1, int d2, int d3, int d4, int d5, int i) {
        return IntStream.of(d1, d2, d3, d4, d5).filter(d -> d == i).sum();
    }

    private static int multipleOfAKind(int d1, int d2, int d3, int d4, int d5, int i) {
        Map<Integer, Long> dicesGroupByValue = groupDiceByValue(d1, d2, d3, d4, d5);
        Optional<Integer> fourOfAKind = keepDiceWithEnoughSibling(dicesGroupByValue, i).map(Map.Entry::getKey).findAny();
        return fourOfAKind.map(d -> d * i).orElse(0);
    }

}



