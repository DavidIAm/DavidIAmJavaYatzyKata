package testpackage;


import static java.util.stream.Collectors.summingInt;

public class ScorerThreeOfAKind implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		return dice.faces.stream().filter(b -> dice.mapCounts.get(b).equals(3)).collect(summingInt(Face::value));
	}

}
