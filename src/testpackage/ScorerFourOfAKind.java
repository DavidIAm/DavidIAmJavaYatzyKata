package testpackage;

public class ScorerFourOfAKind implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		return dice.mapCounts.entrySet().stream().filter(c -> c.getValue().equals(4)).mapToInt(b -> b.getKey().value()
				* 4).sum();
	}

}
