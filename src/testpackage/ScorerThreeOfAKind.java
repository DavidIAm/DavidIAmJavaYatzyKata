package testpackage;

public class ScorerThreeOfAKind implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		return dice.faces.stream().filter(b -> dice.mapCounts().get(b).equals(3)).mapToInt(b -> b.value()).sum();
	}

}
