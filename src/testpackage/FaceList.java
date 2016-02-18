package testpackage;
// This is a list of faces.  It is very simple
// It is probably overkill but I was exploring how to create a type that looks externally less parameterized.
// This looks nicer from outside the class with less parameterizations
import java.util.ArrayList;
import java.util.List;

public class FaceList {
	private List<Face> faceList = new ArrayList<>();

	public Face get(Integer index) {
		return faceList.get(index);
	}

	public void add(Face index) {
		faceList.add(index);
	}

	public Integer size() {
		return faceList.size();

	}
}