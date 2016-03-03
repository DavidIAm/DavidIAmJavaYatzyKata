package testpackage;

import java.util.List;
import java.util.Map.Entry;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.summingInt;

public class ScorerLargeStraight implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		List<Entry<Face, Integer>> largeColl = dice.mapCounts.entrySet().stream().filter(c -> c.getValue().equals(1))
				.collect(toList());
		if (largeColl.stream().noneMatch(b -> b.getKey() == Face.ONE)) {
			if (largeColl.size() == 5) {
				return dice.faces.stream().collect(summingInt(Face::value));
			}
		}
		return 0;
	}

}
