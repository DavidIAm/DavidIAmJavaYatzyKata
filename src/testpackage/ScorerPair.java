package testpackage;

public class ScorerPair implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		return dice.faces.stream().filter(b -> dice.mapCounts.get(b).equals(2)).max((a, b) -> Integer.compare(a
				.ordinal(), b.ordinal())).map(b -> b.value() * 2).orElse(0);
	}

}
