package testpackage;

import java.util.Map;

// The Yatzy class provides the answer method which scores the result.
public class Yatzy {

	// This uses a case swi]tch to select the various elements of the throw
	public static int answer(Throw dice, Scoring scoreType) {
		Map<Face, Integer> faceCounts = dice.mapCounts();
		switch (scoreType) {
		case YATZY:
			if (faceCounts.keySet().size() == 1) {
				return 50;
			}
			break;

		case PAIR:
			Face maxDie;
			maxDie = Face.ONE;
			boolean paired;
			paired = false;
			// I think the line below looks as bad as perl with all the < > and such.
			for (Map.Entry<Face, Integer> countEntry : faceCounts.entrySet()) {
				if (countEntry.getValue() == 2) {
					paired = true;
					if (countEntry.getKey().value() >= maxDie.value()) {
						maxDie = countEntry.getKey();
					}
				}
			}
			if (paired) {
				return (maxDie.value()) * 2; // twice the plus one of the
												// value? bleh.
			}
			break;
		case TWOPAIR:
			FaceList faceList = new FaceList();
			for (Map.Entry<Face, Integer> countEntry : faceCounts.entrySet()) {
				if (countEntry.getValue() == 2) {
					faceList.add(countEntry.getKey());
				}
			}
			if (faceList.size() == 2) {
				return ((faceList.get(0).value()) * 2 + (faceList.get(1).value()) * 2);
			}
			break;
		case THREEOFAKIND:
			for (Map.Entry<Face, Integer> countEntry : faceCounts.entrySet()) {
				if (countEntry.getValue() == 3) {
					return ((countEntry.getKey().value()) * 3);
				}
			}
			break;
		case FOUROFAKIND:
			for (Map.Entry<Face, Integer> countEntry : faceCounts.entrySet()) {
				if (countEntry.getValue() == 4) {
					return ((countEntry.getKey().value()) * 4);
				}
			}
			break;
		case SMALLSTRAIGHT:
			if (faceCounts.containsKey(Face.TWO) && faceCounts.containsKey(Face.THREE) && faceCounts.containsKey(
					Face.FOUR)) {
				if (faceCounts.containsKey(Face.ONE)) {
					return 15;
				} else {
					return 0;
				}
			}
			break;
		case LARGESTRAIGHT:
			if (faceCounts.containsKey(Face.TWO) && faceCounts.containsKey(Face.THREE) && faceCounts.containsKey(
					Face.FOUR)) {
				if (faceCounts.containsKey(Face.SIX)) {
					return 20;
				} else {
					return 0;
				}
			}
			break;
		case FULLHOUSE:
			if (faceCounts.entrySet().size() == 2) {
				for (Integer oneofthem : faceCounts.values()) {
					if (oneofthem == 1 || oneofthem == 4) {
						return 0; // shortcut! Must have been a 4/1 split.
					}
				}
				// Streams are fun. It lets me map like perl.
				// map-reduce is fun. sum is short for reduce(a+b)
				return dice.faces.stream().mapToInt(b -> b.value()).sum();
			}
			break;
		}

		return 0;
	}

}