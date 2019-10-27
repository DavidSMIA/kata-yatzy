import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(3,3,4,5,1));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(6,6,6,6,6));
        assertEquals(0, Yatzy.yatzy(6,6,6,6,3));
    }

    @Test public void test_1s() {
        assertEquals(1, Yatzy.ones(1,2,3,4,5),1);
        assertEquals(2, Yatzy.ones(1,2,1,4,5));
        assertEquals(0, Yatzy.ones(6,2,2,4,5));
        assertEquals(4, Yatzy.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s() {
        assertEquals(0, Yatzy.twos(1,4,3,5,6));
        assertEquals(4, Yatzy.twos(1,2,3,2,6));
        assertEquals(10, Yatzy.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(0, Yatzy.threes(1,2,4,2,5));
        assertEquals(6, Yatzy.threes(1,2,3,2,3));
        assertEquals(12, Yatzy.threes(2,3,3,3,3));
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, Yatzy.fours(4,4,4,5,5));
        assertEquals(8, Yatzy.fours(4,4,5,5,5));
        assertEquals(4, Yatzy.fours(4,5,5,5,5));
        assertEquals(0, Yatzy.fours(1,5,5,5,5));}

    @Test
    public void fives() {
        assertEquals(0,  Yatzy.fives(4,4,4,1,2));
        assertEquals(10,  Yatzy.fives(4,4,4,5,5));
        assertEquals(15, Yatzy.fives(4,4,5,5,5));
        assertEquals(20, Yatzy.fives(4,5,5,5,5));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, Yatzy.sixes(4,4,4,5,5));
        assertEquals(6, Yatzy.sixes(4,4,6,5,5));
        assertEquals(18, Yatzy.sixes(6,5,6,6,5));
    }

    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.scorePair(3,4,3,5,6));
        assertEquals(10, Yatzy.scorePair(5,3,3,3,5));
        assertEquals(12, Yatzy.scorePair(5,3,6,6,5));
        assertEquals(0, Yatzy.scorePair(1,2,3,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.twoPair(3,3,5,4,5));
        assertEquals(16, Yatzy.twoPair(3,3,5,5,5));
        assertEquals(0, Yatzy.twoPair(3,3,1,2,5));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.threeOfKind(3,3,3,4,5));
        assertEquals(15, Yatzy.threeOfKind(5,3,5,4,5));
        assertEquals(9, Yatzy.threeOfKind(3,3,3,3,5));
        assertEquals(0, Yatzy.threeOfKind(3,3,1,2,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.fourOfAKind(5,5,5,4,5));
        assertEquals(0, Yatzy.fourOfAKind(5,5,1,2,4));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
