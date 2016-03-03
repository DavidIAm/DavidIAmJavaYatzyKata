package testpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

// This represents a throw of five dice
// You must construct it with five <Face> parameters. 
// Their order doesn't matter.
public class Throw {
	public List<Face> faces = new ArrayList<>();

	// This provides a map of Face => count
	// for the throw represented by this object
	// as it is rather important to figure out the groupings and how large they are
	public final Map<Face, Integer> mapCounts;

	Throw(Face a, Face b, Face c, Face d, Face e) {
		faces.add(a);
		faces.add(b);
		faces.add(c);
		faces.add(d);
		faces.add(e);

		mapCounts = faces.stream().collect(groupingBy(identity(), summingInt(k -> 1)));
	}

	public Map<Face, Integer> faceCounts() {
		Map<Face, Integer> faceCounts = new HashMap<>();
		for (Face thisFace : faces) {
			int count;
			count = faceCounts.getOrDefault(thisFace, 0) + 1;
			faceCounts.put(thisFace, count);
		}
		return faceCounts;
	}
}