package testpackage;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ScorerTwoPair implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		List<Entry<Face, Integer>> twoColl = dice.mapCounts.entrySet().stream().filter(c -> c.getValue().equals(2))
				.collect(Collectors.toList());
		if (twoColl.size() == 2) {
			return twoColl.stream().mapToInt(b -> b.getKey().value() * 2).sum();
		}
		return 0;
	}

}
