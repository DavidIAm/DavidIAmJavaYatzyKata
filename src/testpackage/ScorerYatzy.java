package testpackage;

public class ScorerYatzy implements Scorer {
	public Integer answer(Throw dice) {
		if (dice.mapCounts().keySet().size() == 1) {
			return 50;
		}
		return 0;
	}
}
