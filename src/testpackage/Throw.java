package testpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// This represents a throw of five dice
// You must construct it with five <Face> parameters. 
// Their order doesn't matter.
public class Throw {
	public List<Face> faces = new ArrayList<>();

	Throw(Face a, Face b, Face c, Face d, Face e) {
		this.faces.add(a);
		this.faces.add(b);
		this.faces.add(c);
		this.faces.add(d);
		this.faces.add(e);
	}

	// This provides a map of Face => count 
	// for the throw represented by this object
	// as it is rather important to figure out the groupings and how large they are
	public Map<Face, Integer> mapCounts() {
		Map<Face, Integer> faceCounts = new HashMap<>();// <Face, Integer>();
		for (Face thisFace : this.faces) {
			int count;
			count = faceCounts.getOrDefault(thisFace, 0) + 1;
			faceCounts.put(thisFace, count);
		}
		return faceCounts;
	}
}