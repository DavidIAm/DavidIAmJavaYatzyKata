package testpackage;

import java.util.List;
import java.util.Map.Entry;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

public class ScorerSmallStraight implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		List<Entry<Face, Integer>> smallColl = dice.mapCounts.entrySet().stream().filter(c -> c.getValue().equals(1))
				.collect(toList());
		if (smallColl.stream().noneMatch(b -> b.getKey() == Face.SIX)) {
			if (smallColl.size() == 5) {
				return dice.faces.stream().collect(summingInt(Face::value));
			}
		}
		return 0;
	}

}
