package testpackage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// The Yatzy class provides the answer method which scores the result.
public class Yatzy {
    
	// This uses a case switch to select the various elements of the throw
	public static int answer(Throw dice, Scoring scoreType) {

			return AnswerFactory.create(scoreType).answer(dice);

	}

}