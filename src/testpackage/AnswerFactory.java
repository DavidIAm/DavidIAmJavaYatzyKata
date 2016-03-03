package testpackage;

public class AnswerFactory {
	static Scorer create(Scoring type) {
		switch (type) {
			case YATZY: return new ScorerYatzy();
			case PAIR: return new ScorerPair();
			case TWOPAIR: return new ScorerTwoPair();
			case THREEOFAKIND: return new ScorerThreeOfAKind();
			case FOUROFAKIND: return new ScorerFourOfAKind();
			case SMALLSTRAIGHT: return new ScorerSmallStraight();
			case LARGESTRAIGHT: return new ScorerLargeStraight();
			case FULLHOUSE: return new ScorerFullHouse();
		}
		return new ScorerNull();
	}
}
