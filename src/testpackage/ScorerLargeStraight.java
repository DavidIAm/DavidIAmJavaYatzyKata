package testpackage;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ScorerLargeStraight implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		List<Entry<Face, Integer>> largeColl = dice.mapCounts().entrySet().stream().filter(c -> c.getValue().equals(1))
				.collect(Collectors.toList());
		if (largeColl.stream().noneMatch(b -> b.getKey() == Face.ONE)) {
			if (largeColl.size() == 5) {
				return dice.faces.stream().mapToInt(b -> b.value()).sum();
			}
		}
		return 0;
	}

}
