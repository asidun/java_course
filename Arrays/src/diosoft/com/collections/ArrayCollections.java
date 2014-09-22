package diosoft.com.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayCollections {
	
	
	@SuppressWarnings("null")
	public List<Person> union(List<Person> leftArray, List<Person> rightArray){
		Set<Person> result = new HashSet<Person>();		
		if (leftArray == null && leftArray.isEmpty()) return rightArray;
		if (rightArray == null && leftArray.isEmpty()) return leftArray;
		
		result.addAll(leftArray);
		result.addAll(rightArray);
		
		List<Person> out = new ArrayList<Person>();
		out.addAll(result);
		
		return out;
	}

}
