package testpackage;

import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

	@Test
	public void yatzy_scoring_ones() {

		assertEquals(50, Yatzy.answer(new Throw(Face.ONE, Face.ONE, Face.ONE, Face.ONE, Face.ONE), Scoring.YATZY));
		// 1,1,1,1,1 scores 50 as yatzy
	}

	@Test
	public void yatzy_scoring_fives() {

		assertEquals(50, Yatzy.answer(new Throw(Face.FIVE, Face.FIVE, Face.FIVE, Face.FIVE, Face.FIVE), Scoring.YATZY));
		// 5,5,5,5,5 scores 50 as yatzy
	}

	@Test
	public void yatzy_scoring_four() {

		assertEquals(0, Yatzy.answer(new Throw(Face.FIVE, Face.FIVE, Face.FIVE, Face.FIVE, Face.ONE), Scoring.YATZY));
		// 5,5,5,5,1 scores 0 as yatzy
	}

	@Test
	public void yatzy_scoring_full_house() {

		assertEquals(0, Yatzy.answer(new Throw(Face.THREE, Face.THREE, Face.THREE, Face.FOUR, Face.FOUR),
				Scoring.YATZY));
		// 3,3,3,4,4 scores 8 (4+4) as yatzy
	}

	@Test
	public void pair_scoring_two_pair() {

		assertEquals(12, Yatzy.answer(new Throw(Face.ONE, Face.ONE, Face.SIX, Face.TWO, Face.SIX), Scoring.PAIR));
		// 1,1,6,2,6 scores 12 (6+6) as pair
	}

	@Test
	public void pair_scoring_three() {

		assertEquals(0, Yatzy.answer(new Throw(Face.THREE, Face.THREE, Face.THREE, Face.FOUR, Face.ONE), Scoring.PAIR));
		// 3,3,3,4,1 scores 0 as pair
	}

	@Test
	public void pair_scoring_four() {

		assertEquals(0, Yatzy.answer(new Throw(Face.THREE, Face.THREE, Face.THREE, Face.THREE, Face.ONE),
				Scoring.PAIR));
		// 3,3,3,3,1 scores 0 as pair
	}

	@Test
	public void two_pair_scoring_two_pair() {

		assertEquals(8, Yatzy.answer(new Throw(Face.ONE, Face.ONE, Face.TWO, Face.THREE, Face.THREE), Scoring.TWOPAIR));
		// 1,1,2,3,3 scores 8 (1+1+3+3) as two pair
	}

	@Test
	public void two_pair_scoring_one_pair() {

		assertEquals(0, Yatzy.answer(new Throw(Face.ONE, Face.ONE, Face.TWO, Face.THREE, Face.FOUR), Scoring.TWOPAIR));
		// 1,1,2,3,4 scores 0 as two pair
	}

	@Test
	public void two_pair_scoring_full_hosue() {

		assertEquals(0, Yatzy.answer(new Throw(Face.ONE, Face.ONE, Face.TWO, Face.TWO, Face.TWO), Scoring.TWOPAIR));
		// 1,1,2,2,2 scores 0 as two pair
	}

	@Test
	public void three_of_kind_scoring_three() {
		assertEquals(9, Yatzy.answer(new Throw(Face.THREE, Face.THREE, Face.THREE, Face.FOUR, Face.FIVE),
				Scoring.THREEOFAKIND));
		// 3,3,3,4,5 scores 9 (3+3+3) as three of a kind
	}

	@Test
	public void three_of_kind_scoring_pair() {
		assertEquals(0, Yatzy.answer(new Throw(Face.THREE, Face.THREE, Face.FOUR, Face.FIVE, Face.SIX),
				Scoring.THREEOFAKIND));
		// 3,3,4,5,6 scores 0 as three of a kind
	}

	@Test
	public void three_of_kind_scoring_four() {
		assertEquals(0, Yatzy.answer(new Throw(Face.THREE, Face.THREE, Face.THREE, Face.THREE, Face.ONE),
				Scoring.THREEOFAKIND));
		// 3,3,3,3,1 scores 0 as three of a kind
	}

	@Test
	public void four_of_kind_scoring_four_twos() {
		assertEquals(8, Yatzy.answer(new Throw(Face.TWO, Face.TWO, Face.TWO, Face.TWO, Face.FIVE),
				Scoring.FOUROFAKIND));
		// 2,2,2,2,5 scores 8 (2+2+2+2) as four of a kind
	}

	@Test
	public void four_of_kind_scoring_full_house() {
		assertEquals(0, Yatzy.answer(new Throw(Face.TWO, Face.TWO, Face.TWO, Face.FIVE, Face.FIVE),
				Scoring.FOUROFAKIND));
		// 2,2,2,5,5 scores 0 as four of a kind
	}

	@Test
	public void four_of_kind_scoring_five_twos() {
		assertEquals(0, Yatzy.answer(new Throw(Face.TWO, Face.TWO, Face.TWO, Face.TWO, Face.TWO), Scoring.FOUROFAKIND));
		// 2,2,2,2,2 scores 0 as four of a kind
	}

	@Test
	public void small_straight_scoring_small() {
		assertEquals(15, Yatzy.answer(new Throw(Face.ONE, Face.TWO, Face.THREE, Face.FOUR, Face.FIVE),
				Scoring.SMALLSTRAIGHT));
		// 1,2,3,4,5 scores 15 as small straight
	}

	@Test
	public void large_straight_scoring_large() {
		assertEquals(20, Yatzy.answer(new Throw(Face.TWO, Face.THREE, Face.FOUR, Face.FIVE, Face.SIX),
				Scoring.LARGESTRAIGHT));
		// 2,3,4,5,6 scores 20 as a large straight
	}

	@Test
	public void full_house_scoring_full_house() {
		assertEquals(8, Yatzy.answer(new Throw(Face.ONE, Face.ONE, Face.TWO, Face.TWO, Face.TWO), Scoring.FULLHOUSE));
		// 1,1,2,2,2 scores 8 (1+1+2+2+2) as a full house
	}

	@Test
	public void full_house_scoring_two_pair() {
		assertEquals(0, Yatzy.answer(new Throw(Face.TWO, Face.TWO, Face.THREE, Face.THREE, Face.FOUR),
				Scoring.FULLHOUSE));
		// 2,2,3,3,4 scores 0 as a full house
	}

	@Test
	public void full_house_scoring_yatzy() {
		assertEquals(0, Yatzy.answer(new Throw(Face.FOUR, Face.FOUR, Face.FOUR, Face.FOUR, Face.FOUR),
				Scoring.FULLHOUSE));
		// 4,4,4,4,4 scores 0 as a full house
	}

}
