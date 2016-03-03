package testpackage;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.summingInt;


public class ScorerFullHouse implements Scorer {

	@Override
	public Integer answer(Throw dice) {
		List<Face> fullColl = dice.faces.stream().filter(b -> dice.mapCounts.get(b) == 2 || (dice.mapCounts.get(b) == 3)).collect(toList());
		if (fullColl.size() == 5) {
			return dice.faces.stream().collect(summingInt(Face::value));
		}
		return 0;
	}

}
