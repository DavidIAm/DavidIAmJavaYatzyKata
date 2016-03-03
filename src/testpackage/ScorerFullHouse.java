package testpackage;

import java.util.List;
import java.util.stream.Collectors;

public class ScorerFullHouse implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		List<Face> fullColl = dice.faces.stream().filter(b -> dice.mapCounts().get(b) == 2 || dice.mapCounts().get(b) == 3).collect(Collectors.toList());
		if (fullColl.size() == 5) {
			return dice.faces.stream().mapToInt(b -> b.value()).sum();
		}
		return 0;
	}

}
